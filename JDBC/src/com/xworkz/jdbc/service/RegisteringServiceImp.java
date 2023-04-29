package com.xworkz.jdbc.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.jdbc.dto.RegisteringDTO;
import com.xworkz.jdbc.repository.RegistrationRepo;

public class RegisteringServiceImp implements RegistrationService{

	private RegistrationRepo registrationRepo;
	@Override
	public Set<ConstraintViolation<RegisteringDTO>> validate(RegisteringDTO dto) 
	{
		ValidatorFactory validated=Validation.buildDefaultValidatorFactory();
		Validator valid=validated.getValidator();
		Set<ConstraintViolation<RegisteringDTO>> validations =valid.validate(dto);
		if(validations.isEmpty())
		{
			System.out.println("on validate method");
			boolean save=this.registrationRepo.onSave(dto);
			System.out.println(save);
		}else {
			System.out.println("violations");
		}
		return validations;
	}

}
