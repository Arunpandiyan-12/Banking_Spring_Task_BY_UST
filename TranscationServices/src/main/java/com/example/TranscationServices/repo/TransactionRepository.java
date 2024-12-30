package com.example.TranscationServices.repo;




import com.example.TranscationServices.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountNumber(String accountNumber);
}
