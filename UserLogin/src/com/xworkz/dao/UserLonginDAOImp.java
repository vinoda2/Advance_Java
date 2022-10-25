package com.xworkz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLonginDAOImp implements UserLoginDAO {

	@Override
	public boolean insertDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			Statement st=con.createStatement();
			String sql="insert into UserDetails values(5,'appu','appu@3')";
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Record inserted succeff fully");
			}else {
				System.out.println("not inserted");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			Statement st=con.createStatement();
			String sql="update UserDetails set id=3,username='sit' where id=3";
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("updated successfully");
			}else {
				System.out.println("not updated");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean readDetails() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
		Statement st=con.createStatement();
			String read="select * from UserDetails";
			ResultSet rs=st.executeQuery(read);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		return false;
	}

	@Override
	public boolean deleteDetails() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			Statement st=con.createStatement();
			String sql="delete from UserDetails where id=1";
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("record deleted successfully");
			}else {
				System.out.println("record not found ");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
