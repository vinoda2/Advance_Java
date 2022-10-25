package com.xworkz.dao;

import java.sql.SQLException;

public interface UserLoginDAO {
	public abstract boolean insertDetails() throws SQLException;;
	public abstract boolean updateDetails()throws SQLException;;
	public abstract boolean readDetails() throws SQLException;
	public abstract boolean deleteDetails() throws SQLException;

}
