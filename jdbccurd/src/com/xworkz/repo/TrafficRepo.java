package com.xworkz.repo;

import com.xworkz.dto.TrafficDTO;

public interface TrafficRepo {
	 abstract boolean onSave(TrafficDTO dto);

}
