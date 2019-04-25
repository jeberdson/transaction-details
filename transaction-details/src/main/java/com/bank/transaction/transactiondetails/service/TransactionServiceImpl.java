package com.bank.transaction.transactiondetails.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.transaction.transactiondetails.dao.TransactionDao;
import com.bank.transaction.transactiondetails.model.Transaction;
import com.bank.transaction.transactiondetails.model.TransactionDetail;

public class TransactionServiceImpl implements TransactionService {

	static Logger log = Logger.getLogger(TransactionServiceImpl.class.getName());

	@Autowired
	TransactionDao transactionDao;

	@Override
	public void saveTransaction(Transaction transaction) {
		transactionDao.save(transaction);
	}

	@Override
	public TransactionDetail getStats() {
		List<Transaction> transactionList = transactionDao.getAll();

		List<Transaction> recentTransactions = new ArrayList<>();

		for (int index = 0; index < transactionList.size(); index++) {
			Transaction transaction = transactionList.get(index);
			ZonedDateTime transactionTime = ZonedDateTime.parse(transaction.getTime())
					.withZoneSameLocal(TimeZone.getTimeZone("UTC").toZoneId());

			if (transactionTime.isAfter(ZonedDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()).minusMinutes(10))) {
				recentTransactions.add(transaction);
			}
		}

		return prepareTransactionDetail(recentTransactions);
	}

	private TransactionDetail prepareTransactionDetail(List<Transaction> recentTransactions) {

		int count = recentTransactions.size();

		double maxTransaction = recentTransactions.stream().filter(Objects::nonNull).map(Transaction::getAmount)
				.mapToDouble(amount -> amount).max().getAsDouble();
		double minTransaction = recentTransactions.stream().filter(Objects::nonNull).map(Transaction::getAmount)
				.mapToDouble(amount -> amount).min().getAsDouble();
		double sum = recentTransactions.stream().filter(Objects::nonNull).map(Transaction::getAmount)
				.mapToDouble(amount -> amount).sum();
		double avg = sum / count;

		return TransactionDetail.builder().count(count).avg(avg).max(maxTransaction).min(minTransaction).sum(sum)
				.build();
	}

	@Override
	public void deleteAll() {
		transactionDao.deleteAll();
	}

}
