package com.xworkz.runner;

import com.xworkz.Mobile;
import com.xworkz.MobileFactory;

public class MobilePrice {
	public static void main(String[] args) {
		Mobile m=MobileFactory.getPrice("Iphone");
		m.getPrice();
	}
}
