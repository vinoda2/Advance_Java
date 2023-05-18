package com.xworkz.googlesheetconnection.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilterMainMethod {
	
	public static void main(String[] args) {
		Map<String, Integer> myRange=new LinkedHashMap<String,Integer>();
		myRange.put("startRow",1);
		myRange.put("startColumn", 0);
		myRange.put("endColumn",4);
		myRange.put("endRow",100);
		
		System.out.println(myRange);
	
	}
	

}
