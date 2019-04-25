package com.bank.transaction.transactiondetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bank.transaction.transactiondetails.dao.TransactionDao;
import com.bank.transaction.transactiondetails.dao.TransactionDaoImpl;

@Configuration
public class DaoConfig {

	@Bean
	public TransactionDao transactionDaoImpl() {
		return new TransactionDaoImpl();
	}

}
