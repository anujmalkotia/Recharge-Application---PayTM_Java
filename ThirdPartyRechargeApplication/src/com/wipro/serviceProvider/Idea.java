package com.wipro.serviceProvider;

import java.util.HashMap;
import java.util.Map;

import com.wipro.gateway.Paytm;

public class Idea implements Paytm{
	
	public static Map<Long, Integer> contacts;

	public Idea(){
		contacts = new HashMap<>();
		packs.clear();
		packs.put(176, "Rs. 176, Validity 10 days");
		packs.put(230, "Rs. 230, Validity 5 days");
		packs.put(312, "Rs. 312, Validity 20 days");
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
