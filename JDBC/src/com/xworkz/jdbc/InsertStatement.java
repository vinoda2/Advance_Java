package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.dto.RegisteringDTO;

public class InsertStatement {
	public static void main(String[] args) throws SQLException {
		RegisteringDTO dto = new RegisteringDTO(7, "soda");
		try {
			System.out.println("loading the driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
			System.out.println("create a connection");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crop" ,"root", "root");
			System.out.println("create query");
			String query="insert into cropdetails(id,cropName) values(?,?);";
			Statement stmt=con.createStatement();
			PreparedStatement rs=con.prepareStatement(query);
			System.out.println("table created");
			
			rs.setInt(1,dto.getId());
			rs.setString(2,dto.getCropName());
			//rs.setString(3,"Jola");
			int i=rs.executeUpdate();
			if(i!=0) {
				System.out.println("value inserted");
			}else {
				System.out.println("no values");
			}
			
			/*
			while(rs.next()) {
				//System.out.println("institute");
				System.out.println("institute"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}*/
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
