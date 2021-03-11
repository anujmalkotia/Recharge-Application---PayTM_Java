package com.wipro.serviceProvider;

import java.util.HashMap;
import java.util.Map;

import com.wipro.gateway.Paytm;

public class Vodafone implements Paytm{
	public static Map<Long, Integer> contacts;

	public Vodafone(){
		contacts = new HashMap<>();
		packs.clear();
		packs.put(230, "Rs. 230, Validity 10 days");
		packs.put(170, "Rs. 170, Validity 5 days");
		packs.put(320, "Rs. 320, Validity 20 days");
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
