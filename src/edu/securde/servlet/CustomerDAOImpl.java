package edu.securde.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {
	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertCustomer(Customer c) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("insert into users values(?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getPassword());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Customer getCustomer(String userid, String pass) {
		Customer c = new Customer();
		
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("SELECT * FROM users WHERE userID=? AND password=?");
			ps.setString(1, userid);
			ps.setString(2,  pass);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setUsername(rs.getString(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setEmail(rs.getString(5));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
