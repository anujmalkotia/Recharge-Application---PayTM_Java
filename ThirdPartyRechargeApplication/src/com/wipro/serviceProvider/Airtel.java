package com.wipro.serviceProvider;

import java.util.HashMap;
import java.util.Map;

import com.wipro.gateway.Paytm;

public class Airtel implements Paytm {
	
	public static Map<Long, Integer> contacts;

	public Airtel() {
		contacts = new HashMap<>();
		packs.clear();
		packs.put(189, "Rs. 189, Validity 10 days");
		packs.put(280, "Rs. 280, Validity 5 days");
		packs.put(310, "Rs. 310, Validity 20 days");
	}

	@Override
	public void recharge(long mobileNo, int amt) {
		contacts.put(mobileNo, amt);
		System.out.println("!! Recharge Sucessfully Done !!");
	}

	@Override
	public void denomination() {
		packs.values().forEach(System.out::println);
	}
	
	public static Map<Long, Integer> balEnquiry(){
		return contacts;
	}
}
