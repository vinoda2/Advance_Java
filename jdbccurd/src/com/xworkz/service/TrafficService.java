package com.xworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.dto.TrafficDTO;

public interface TrafficService {
	
	public boolean validateAndSave(TrafficDTO dto);
}