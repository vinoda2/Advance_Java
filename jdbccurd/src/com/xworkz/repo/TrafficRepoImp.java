package com.xworkz.repo;

import com.xworkz.dto.TrafficDTO;

public class TrafficRepoImp implements TrafficRepo{

	@Override
	public boolean onSave(TrafficDTO dto) {
		System.out.println("this is onsave method");
		return false;
	}

}
