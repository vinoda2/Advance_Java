package com.xworkz.runner;

import java.sql.SQLException;

import com.xworkz.dao.UserLoginDAO;
import com.xworkz.dao.UserLonginDAOImp;
import com.xworkz.dto.UserLoginDTO;

public class UserRunner {

	public static void main(String[] args) throws SQLException {
		UserLoginDTO dto= new UserLoginDTO();
		UserLoginDAO dao = new UserLonginDAOImp();
		dao.readDetails();
		dao.insertDetails();
		dao.updateDetails();
		dao.deleteDetails();
		
	}

}
