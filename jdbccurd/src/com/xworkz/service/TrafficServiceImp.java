package com.xworkz.service;
import com.xworkz.dto.TrafficDTO;
import com.xworkz.repo.TrafficRepo;

public class TrafficServiceImp implements TrafficService {
	TrafficRepo trafficRepo;

	public TrafficServiceImp(TrafficRepo trafficRepo) {
		this.trafficRepo = trafficRepo;
	}

	@Override
	public boolean validateAndSave(TrafficDTO dto) {
		System.out.println("this is validate method");
		System.out.println(this.trafficRepo.onSave(dto));
		return true;
	}
}
