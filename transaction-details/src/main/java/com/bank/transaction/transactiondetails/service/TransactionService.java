package com.bank.transaction.transactiondetails.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.bank.transaction.transactiondetails.model.Transaction;
import com.bank.transaction.transactiondetails.model.TransactionDetail;

@Service
public interface TransactionService {

	static Logger log = Logger.getLogger(TransactionService.class.getName());

	/*
	 * saves the transaction
	 */
	void saveTransaction(Transaction transaction);

	/*
	 * Gets the stats in last one minute
	 */
	TransactionDetail getStats();

	/*
	 * Deletes all the transaction
	 */
	void deleteAll();

}
