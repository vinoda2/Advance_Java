package com.xworkz.aeroplane.service;

import com.xworkz.aeroplane.dto.AeroplaneDTO;

public interface AeroplaneService {
	public abstract boolean validateAndSave(AeroplaneDTO dto);

}
