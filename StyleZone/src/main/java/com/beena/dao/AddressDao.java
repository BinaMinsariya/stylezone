package com.beena.dao;

import java.util.List;

import com.beena.model.Address;
import com.beena.model.UserDetails;


public interface AddressDao
{
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(UserDetails user);

}