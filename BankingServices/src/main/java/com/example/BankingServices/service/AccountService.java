package com.example.BankingServices.service;

import com.example.BankingServices.DTO.AccountDTO;
import com.example.BankingServices.DTO.ResponseDTO;
import com.example.BankingServices.DTO.TransactionDTO;
import com.example.BankingServices.entity.Account;
import com.example.BankingServices.repo.AccountRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.sql.Driver;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepository;

   @Autowired
   WebClient webClient;

    public Account createAccount(Account account) {
        if (accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new RuntimeException("Account number already exists");
        }
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account updateAccount(Long id,  Account account) {
        Account existingAccount = getAccountById(id);
        existingAccount.setAccountName(account.getAccountName());
        existingAccount.setBalance(account.getBalance());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @CircuitBreaker(name = "account-service", fallbackMethod = "fallbackGetTransaction")
    public ResponseDTO getByAccountNumber(String accountNumber) {
        ResponseDTO responseDto = new ResponseDTO();
        List<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if(account.isEmpty()){
            throw new RuntimeException("No accounts found");
        }

        AccountDTO accountDTO = mapToDriverDto(account.get(0));

        List<TransactionDTO> customerdtolist =webClient.get()
                .uri("http://localhost:8083/transactions/" + accountNumber)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TransactionDTO>>() {
                })
                .block();

        responseDto.setAccountDTO(accountDTO);
        responseDto.setTransactionDTO(customerdtolist);

        return responseDto;
    }
    public ResponseDTO fallbackGetBooking(String AccountNumber, Throwable throwable) {
        ResponseDTO fallbackResponse = new ResponseDTO();
        fallbackResponse.setTransactionDTO(null);
        fallbackResponse.setAccountDTO(null);
        return fallbackResponse; // Return an empty response or a default response
    }

    private AccountDTO mapToDriverDto(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountName(account.getAccountName());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBalance(account.getBalance());

        return accountDTO;
    }
}
