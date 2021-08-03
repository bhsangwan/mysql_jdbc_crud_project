package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myapp.entity.Address;
import com.myapp.utils.DBUtils;

public class AddressDAOImpl implements AddressDAO{

	private final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private final String user = "root";
	private final String password = "root@123";
	
	Connection conn = null;
	
	@Override
	public boolean saveAddress(Address address) {
		
		boolean addressSaved = false;
		
		try {
			conn = DBUtils.getConnection("test");
			// STEP 2 - Create Statement Objects
			String query = "insert into address (city, state, pin) values (?,?,?)";
			PreparedStatement pst = DBUtils.getPreparedStatement(query);
			
			pst.setString(1, address.getCity());
			pst.setString(2, address.getState());
			pst.setString(3, address.getPin());
			
			// STEP 3 - Execute Statement (to get or insert or update or delete or etc)
			
			int rows = pst.executeUpdate();
			
			// STEP 4 - Collect the result
			if(rows > 0) {
				addressSaved = true;
				System.out.println("Data inserted successfully..!");
			}
			else
				System.out.println("Something went wrong...!");
			
			DBUtils.closeConnections();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return addressSaved;
	}

	@Override
	public Address getAddress(int id) {
		Address address = null;
		//Get Connection
		conn = DBUtils.getConnection("test");
		String sql = "SELECT * FROM address WHERE id=?";
		PreparedStatement pst = DBUtils.getPreparedStatement(sql);
		try {
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			//Collecting the Result
			
			if(rs.next()) {
				//int val = rs.getInt(1);
				address = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
			//close the connection
			DBUtils.closeConnections();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return address;
	}

	@Override
	public boolean deleterAddress(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

}
