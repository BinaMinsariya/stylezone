package com.beena.handler;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.beena.dao.UserDao;
import com.beena.model.Address;
import com.beena.model.Cart;
import com.beena.model.RegisterModel;
import com.beena.model.UserDetails;
@Component
public class RegisterHandler 
{
	@Autowired
	UserDao userdao;
	
	public RegisterModel initFlow()
	{
		return new RegisterModel();
	}
	
	public String bindingUser(RegisterModel registerModel,UserDetails users,MessageContext messageContext)
	{
		 String status="success";
		if(userdao.getUserByEmail(users.getEmailid())!=null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"emailid").defaultText("Email already exists").build());
			status = "failure";
		}
		registerModel.setUsers(users);
		return status;
	}
	public void bindingUserAddresss(RegisterModel registerModel,Address address)
	{
		registerModel.setUserAddress(address);
		System.out.println(registerModel.getUsers().getUsername());
	}
	public void bindingBillingAddress(RegisterModel registerModel,Address address)
	{
		registerModel.setBillingAddress(address);
		
	}
	
	public String saveUser(RegisterModel registerModel)
	{
		//getting user
		UserDetails users=registerModel.getUsers();
		//getting user address
		Address userAddress=registerModel.getUserAddress();
		//getting billing address
		Address billingAddress=registerModel.getBillingAddress();
		//getting cart 
		Cart cart=new Cart();
		registerModel.setCart(cart);
		System.out.println("cart is object::::::::::::::::::::::"+cart);
		
		cart.setUsers(users);
		users.setCart(cart);
		billingAddress.setUsers(users);
		userAddress.setUsers(users);
		List<Address> addresslist=new ArrayList<Address>();
		addresslist.add(userAddress);
		addresslist.add(billingAddress);
		users.setAddress(addresslist);
		try{
		userdao.addUsers(users);
		return "success";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "failure";
		}
	}
}
