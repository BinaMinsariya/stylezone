package com.beena.dao;

import com.beena.model.Cart;

public interface CartDao 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean resetCart(int id);

}
