package com.example.BankingServices.DTO;

import java.util.List;

public class ResponseDTO {
    private  AccountDTO accountDTO;
    private List<TransactionDTO> transactionDTO;

    public ResponseDTO() {
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public ResponseDTO(AccountDTO accountDTO, List<TransactionDTO> transactionDTO) {
        this.accountDTO = accountDTO;
        this.transactionDTO = transactionDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    public List<TransactionDTO> getTransactionDTO() {
        return transactionDTO;
    }

    public void setTransactionDTO(List<TransactionDTO> transactionDTO) {
        this.transactionDTO = transactionDTO;
    }
}
