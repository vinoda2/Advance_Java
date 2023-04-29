package com.xworkz.event.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Map {
	public static void main(String[] args) {
		HashMap m = new HashMap();
		m.put(123,"Vinoda");
		m.put(124, "Pinku");
		System.out.println(m.size());
		System.out.println(m);
		System.out.println(m.get(124));
		m.entrySet();
		System.out.println(m);
		LinkedHashMap n = new LinkedHashMap();
		n.put(87, "vinoda");
		HashMap<String,String> map = new HashMap<String,String>();
		map.putAll(n);
		map.putAll(m);
System.out.println(map);
	for(String values:map.values())
	{
		System.out.println("values:"+values);
	}
	for(Object values:map.keySet())
	{
		System.out.println("values:"+(Object)values);
	}
	//Entry.comparingByKey();
	
	TreeMap name = new TreeMap();
	name.put(12,"abs");
	name.put(113, "asf");
	name.put(234,"sdhg");
	System.out.println(name);
	System.out.println(name.firstKey());
	System.out.println(name.lastKey());
	System.out.println(name.firstEntry());
	System.out.println(name.lastEntry());
	System.out.println(name.floorKey(12));
	System.out.println(name.comparator());
	System.out.println(name.pollLastEntry());
	System.out.println(name.floorKey(13));
	
	}
}
