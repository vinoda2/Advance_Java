package com.xworkz.aeroplane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.aeroplane.dto.AeroplaneDTO;
import com.xworkz.aeroplane.repository.AeroplaneRepository;

@Service
public class AeroplaneServiceImp implements AeroplaneService {
	@Autowired
	AeroplaneRepository aeroplaneServiceImp;
	
	public AeroplaneServiceImp() {
		System.out.println("this is AeroplaneServiceImp");
	}
	@Override
	public boolean validateAndSave(AeroplaneDTO dto) {
		return false;
	}

}
