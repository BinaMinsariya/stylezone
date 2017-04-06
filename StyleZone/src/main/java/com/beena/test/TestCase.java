package com.beena.test;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.beena.config.ApplicationContextConfig;
import com.beena.dao.AddressDao;
import com.beena.dao.CartDao;
import com.beena.dao.CartItemDao;
import com.beena.dao.CategoryDao;
import com.beena.dao.ProductDao;
import com.beena.dao.UserDao;
import com.beena.model.Address;
import com.beena.model.Cart;
import com.beena.model.CartItem;
import com.beena.model.Category;
import com.beena.model.Product;
import com.beena.model.UserDetails;

@SuppressWarnings("unused")
public class TestCase 
{
	public static void main(String[] ar)
	{

	@SuppressWarnings("resource")
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	
		/* UserDao userdao =(UserDao) context.getBean("userdao");
		UserDetails user= new UserDetails();
		
		user.setUsername("SaiBaba");
		user.setPassword("password@123");
		user.setEmailid("rama@gmail.com");
		user.setRole("ROLE_ADMIN");
		user.setIs_active(true);
		user.setMobileno("7890909045");
		userdao.addUsers(user);	
	
	

	 /* CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	
	Category category = new Category();
	category.setCategoryName("MensWear");
	categoryDAO.newCategory(category);  */
	
	//product test case
	/*  CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	ProductDao productDAO= (ProductDao) context.getBean("productDAO");
	Product product = new Product();
	product.setProductName("cottoncloth");
	product.setProductPrice(2000);
	product.setQuantity(2);
	product.setStatus(true);
	product.setProductDespription("summer comfort");
	product.setCategory(categoryDAO.getCategory(1));
	productDAO.addProduct(product);  
	
	/* AddressDao addressdao =(AddressDao) context.getBean("addressDao");
	 UserDao userDAO= (UserDao) context.getBean("userdao");
		Address address= new Address();
		
		address.setHouseNo("304");
		address.setStreet("fateh sultan lane");
		address.setCity("hyd");
		address.setState("Telangana");
		address.setCountry("india");
		address.setPin("500050");
		address.setUsers(userDAO.getUser(1));
		addressdao.addAddress(address); */
	

	//cart and cartitem test case
	/* CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
	CartDao cartDao=(CartDao)context.getBean("cartDao");
	ProductDao productDAO= (ProductDao) context.getBean("productDAO");
	UserDao userdao =(UserDao) context.getBean("userdao");
	
	Cart cart=new Cart();
	cart.setId(1);
	cart.setUsers(userdao.getUser(1));
	CartItem cartItem=new CartItem();
	cartItem.setCart(cart);
	cartItem.setQuantity(2);
	Product product=productDAO.get(1);
	cartItem.setProduct(product);
	cartItem.setGrandTotal(cartItem.getQuantity()*product.getProductPrice());
	List<CartItem> cartItems=new ArrayList<>();
	cartItems.add(cartItem);
	cart.setCartitems(cartItems);
	cart.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
	cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
	cartDao.addCart(cart);
	*/
	
	}
	
	
	
}
