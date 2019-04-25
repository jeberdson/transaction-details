package com.bank.transaction.transactiondetails.controller;

import java.net.URI;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transaction.transactiondetails.model.Transaction;
import com.bank.transaction.transactiondetails.model.TransactionDetail;
import com.bank.transaction.transactiondetails.service.TransactionService;

@RestController
public class TransactionController {

	static Logger log = Logger.getLogger(TransactionController.class.getName());

	@Autowired
	TransactionService transactionService;

	@PostMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveTransaction(@RequestBody Transaction transaction) {
		transactionService.saveTransaction(transaction);
		return ResponseEntity.created(URI.create("")).build();
	}

	@GetMapping(path = "/transaction", produces = "application/json")
	public ResponseEntity<Object> getStats() {
		TransactionDetail transactionDetail = transactionService.getStats();
		return ResponseEntity.ok(transactionDetail);
	}

	@DeleteMapping("/transaction")
	public ResponseEntity<Object> deleteAll() {
		transactionService.deleteAll();
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/test")
	public String getValue() {
		return "It is working fine";
	}

}
