package com.xworkz.javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mobile {

	public static void main(String[] args) {
		try {
			Class.forName(Jdbc.driver);
			Connection con=DriverManager.getConnection(Jdbc.jdbcurl,Jdbc.userName,Jdbc.password);
			System.out.println(Jdbc.userName);
			String query="select * from new_table";
			Statement st=con.createStatement();
			ResultSet set=st.executeQuery(query);
			while(set.next()) {
				System.out.println("event:"+set.getString(2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Class.forName(Jdbc.driver);
			Connection con=DriverManager.getConnection(Jdbc.jdbcurl,Jdbc.userName,Jdbc.password);
			System.out.println(Jdbc.userName);
			String query="insert  into new_table values(7,'Holi','simple',2000,'monday')";
			Statement st=con.createStatement();
			boolean i = st.execute(query);
			System.out.println("saved :"+i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
		Class.forName(Jdbc.driver);
		Connection con=DriverManager.getConnection(Jdbc.jdbcurl,Jdbc.userName,Jdbc.password);
		System.out.println(Jdbc.userName);
		String query="insert  into new_table values(?,?,?,?,?)";
		PreparedStatement prepare=con.prepareStatement(query);
		prepare.setInt(1, 8);
		prepare.setString(2,"Navarathri");
		prepare.setString(3,"hard");
		prepare.setInt(4, 500);
		prepare.setString(5,"Tuesday");
		boolean i=prepare.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
