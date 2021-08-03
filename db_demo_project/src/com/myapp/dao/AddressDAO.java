package com.myapp.dao;

import java.util.List;

import com.myapp.entity.*;

public interface AddressDAO {

	public boolean saveAddress(Address address);
	
	public Address getAddress(int id);
	
	public boolean deleterAddress(int id);
	
	public Address updateAddress(Address address);
	
	public List<Address> getAddresses();
	
}
