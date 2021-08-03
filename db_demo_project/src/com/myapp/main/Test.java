package com.myapp.main;

import com.myapp.dao.AddressDAO;
import com.myapp.dao.AddressDAOImpl;
import com.myapp.entity.Address;

public class Test {

	public static void main(String[] args) {
		
		//Address address = new Address(0, "Gadhinagar", "Gujrat", "1221102");
		
		AddressDAO dao = new AddressDAOImpl();
		
		Address address = dao.getAddress(5);
		
		/*
		 * if(dao.saveAddress(address)) {
		 * System.out.println("Address saved successfully..!"); }else {
		 * System.out.println("Error in saving address.. Try again"); }
		 */
		System.out.println(address);
	}

}
