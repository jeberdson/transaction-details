package com.bank.transaction.transactiondetails.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDetail {

	private double sum;

	private double avg;

	private double max;

	private double min;

	private int count;

}
