package com.xworkz.jdbc.repository;

import com.xworkz.jdbc.dto.RegisteringDTO;

public interface RegistrationRepo {
	boolean onSave(RegisteringDTO dto);

}
