package com.beena.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Table
@Entity
public class UserDetails implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	@Size(min=6,message="minimum of 6 characters")
	private String username;
	@Size(min=6,message="minimum of 6 characters")
	private String password;
	@Column(unique=true)
	private String emailid;
	@Column(unique=true)
	@Size(min=1,max=10,message="minimum of 10 characters")
    private String mobileno;
	private String role;
	private boolean is_active;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="users")
	private List<Address> address = new ArrayList<Address>();
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="users")
	private Cart cart;
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Cart getCart() {
		return Cart;
	}
	public void setCart(Cart cart) {
		Cart = cart;
	}
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="users")
	private Cart Cart; 
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	}
