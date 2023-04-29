package com.xworkz.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrafficDTO {

	private int id;
	@NotEmpty
	@NotBlank
	@Size(min=3,message="length should be max 3")
	private String name;
	
}
