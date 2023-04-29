package com.xworkz.jdbc.repository;

import com.xworkz.jdbc.dto.RegisteringDTO;

public class RegistrationRepoImp implements RegistrationRepo {

	@Override
	public boolean onSave(RegisteringDTO dto) {
		System.out.println(dto);
		System.out.println("this is on method");
		return true;
	}

}
