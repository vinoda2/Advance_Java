package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
		public static void main(String[] args) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
				Statement st=con.createStatement();
				String sql="update collegeData set college_id=8,college_name='sit' where college_id=3";
				int rs=st.executeUpdate(sql);
				if(rs==1) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not updated");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}
