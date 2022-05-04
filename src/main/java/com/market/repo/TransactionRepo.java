package com.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions, Integer> {

}
