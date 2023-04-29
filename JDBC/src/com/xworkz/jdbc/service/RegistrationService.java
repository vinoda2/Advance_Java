package com.xworkz.jdbc.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.jdbc.dto.RegisteringDTO;

public interface RegistrationService {
	abstract Set<ConstraintViolation<RegisteringDTO>> validate(RegisteringDTO dto);
}
