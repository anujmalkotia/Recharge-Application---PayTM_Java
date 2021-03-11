package com.wipro.serviceProvider;

import java.util.HashMap;
import java.util.Map;

import com.wipro.gateway.Paytm;

public class Jio implements Paytm {

	public static Map<Long, Integer> contacts;
	
	public Jio(){
		contacts = new HashMap<>();
		packs.clear();
		packs.put(200, "Rs. 200, Validity 10 days");
		packs.put(100, "Rs. 100, Validity 5 days");
		packs.put(300, "Rs. 300, Validity 20 days");
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
