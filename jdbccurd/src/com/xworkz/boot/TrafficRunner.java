package com.xworkz.boot;

import com.xworkz.dto.TrafficDTO;
import com.xworkz.repo.TrafficRepo;
import com.xworkz.repo.TrafficRepoImp;
import com.xworkz.service.TrafficService;
import com.xworkz.service.TrafficServiceImp;

public class TrafficRunner {

	public static void main(String[] args) {
		TrafficDTO dto = new TrafficDTO(1,"role");
		TrafficRepo trafficRepo=new TrafficRepoImp();
		
		TrafficService service = new TrafficServiceImp(trafficRepo);
		service.validateAndSave(dto);
	}
}
