package com.xworkz.jdbc.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisteringDTO {
	private int id;
	@NotBlank
	@NotEmpty
	@Size(min=3)
	private String cropName;	
}
