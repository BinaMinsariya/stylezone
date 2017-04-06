package com.beena.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class RegisterModel implements Serializable
{
	UserDetails users;
	Address billingAddress;
	Address userAddress;
	Cart cart;
	public UserDetails getUsers() {
		return users;
	}
	public void setUsers(UserDetails users) {
		this.users = users;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
