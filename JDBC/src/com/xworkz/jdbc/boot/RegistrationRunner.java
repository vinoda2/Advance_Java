package com.xworkz.jdbc.boot;

import com.xworkz.jdbc.dto.RegisteringDTO;
import com.xworkz.jdbc.service.RegisteringServiceImp;
import com.xworkz.jdbc.service.RegistrationService;

public class RegistrationRunner {
	public static void main(String[] args) {
		RegisteringDTO dto = new RegisteringDTO(8,"Samosa");
		
		RegistrationService service = new RegisteringServiceImp();
		service.validate(dto);
	}
}
