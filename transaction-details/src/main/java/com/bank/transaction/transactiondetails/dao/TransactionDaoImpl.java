package com.bank.transaction.transactiondetails.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.bank.transaction.transactiondetails.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	List<Transaction> transactionData = new CopyOnWriteArrayList<>();

	@Override
	public void deleteAll() {
		transactionData.clear();
	}

	@Override
	public void save(Transaction transaction) {

		transactionData.add(transaction);
		System.out.println(
				"Data is saved. " + "time: " + transaction.getTime() + "  " + "amount: " + transaction.getAmount());
	}

	@Override
	public List<Transaction> getAll() {
		return transactionData;
	}

}
