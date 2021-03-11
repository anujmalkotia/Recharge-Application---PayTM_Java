package com.wipro.controller;

import com.wipro.customExcep.InvalidAmountException;
import com.wipro.gateway.Paytm;

public class TestImplementation {

	public static void recharge(Paytm serviceProvider, int amt, long mobNo) throws InvalidAmountException {

		if (amt <= 10 || amt >= 500)
			throw new InvalidAmountException("Expected to have amount greater than Rs.10 and less than Rs.500");

		if (!Paytm.packs.containsKey(amt))
			throw new InvalidAmountException("No such pack available");

		serviceProvider.recharge(mobNo, amt);
	}

	public static void validateMobileNumber(long mobNo) throws InvalidAmountException {
		
		if ((int) Math.floor(Math.log10(mobNo) + 1) != 10){
			throw new InvalidAmountException("Mobile number must consists of 10 digits");
		}
	}
}
