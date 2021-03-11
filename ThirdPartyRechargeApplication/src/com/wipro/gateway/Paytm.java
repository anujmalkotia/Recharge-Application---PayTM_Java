package com.wipro.gateway;

import java.util.HashMap;
import java.util.Map;

public interface Paytm {
	
	public Map<Integer, String> packs = new HashMap<Integer, String>();
	
	void recharge(long mobileNo, int amt);

	void denomination();
}
