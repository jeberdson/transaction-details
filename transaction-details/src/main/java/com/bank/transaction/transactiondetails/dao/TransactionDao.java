package com.bank.transaction.transactiondetails.dao;

import java.util.List;

import com.bank.transaction.transactiondetails.model.Transaction;

public interface TransactionDao {

	public void deleteAll();

	public void save(Transaction transaction);

	public List<Transaction> getAll();

}
