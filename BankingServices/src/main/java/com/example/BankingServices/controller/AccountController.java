package com.example.BankingServices.controller;
import com.example.BankingServices.DTO.ResponseDTO;
import com.example.BankingServices.entity.Account;
import com.example.BankingServices.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/addaccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Get account by account number, with a more specific path
    @GetMapping("{accountNumber}")
    public ResponseEntity<ResponseDTO> getCustomer(@PathVariable String accountNumber){
        ResponseDTO responseDto = accountService.getByAccountNumber(accountNumber);
        return ResponseEntity.ok(responseDto);
    }
}