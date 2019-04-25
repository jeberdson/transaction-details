package com.bank.transaction.transactiondetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bank.transaction.transactiondetails.service.TransactionService;
import com.bank.transaction.transactiondetails.service.TransactionServiceImpl;

@Configuration
public class SpringConfig {

	@Bean
	public TransactionService transactionService() {
		return new TransactionServiceImpl();
	}

}
