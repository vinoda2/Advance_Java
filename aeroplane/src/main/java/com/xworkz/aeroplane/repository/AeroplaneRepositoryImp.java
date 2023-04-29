package com.xworkz.aeroplane.repository;

import org.springframework.stereotype.Repository;

import com.xworkz.aeroplane.dto.AeroplaneDTO;

@Repository
public class AeroplaneRepositoryImp implements AeroplaneRepository {
	
	
	
	public AeroplaneRepositoryImp() {
		System.out.println("this is AeroplaneRepositoryImp");
	}
	

	@Override
	public boolean saveDTO(AeroplaneDTO dto) {
		
		return false;
	}

}
