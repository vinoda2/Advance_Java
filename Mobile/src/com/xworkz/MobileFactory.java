package com.xworkz;

public class MobileFactory {
	
	public static Mobile getPrice(String mobileType) {
		if(mobileType.equalsIgnoreCase("Mi")) {
			return new Mi();
		}else if(mobileType.equalsIgnoreCase("Lenova")) {
			return new Lenova();
		}else if(mobileType.equalsIgnoreCase("Iphone")) {
			return new Iphone();
		}else if(mobileType.equalsIgnoreCase("OnePluse")){
			return new OnePluse();
		}else {
			return null;
		}
		
	}

}
