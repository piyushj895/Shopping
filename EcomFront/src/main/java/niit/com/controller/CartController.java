package niit.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import niit.com.dao.CartDao;
import niit.com.dao.Dao;
import niit.com.dao.ProductDao;
import niit.com.dao.RegistrationDao;
import niit.com.dao.SupplierDao;
import niit.com.model.Cart;
import niit.com.model.RegistrationForm;

@Controller
public class CartController 
{
@Autowired
Dao dao;
@Autowired
SupplierDao supplierDao;
@Autowired
ProductDao productDao;
@Autowired
CartDao cartDao;
@Autowired
RegistrationDao registrationDao;
@RequestMapping(value="/addToCart",method=RequestMethod.POST)
public String addToCart(HttpServletRequest request,Model m)
{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String name=authentication.getName();
	System.out.println(name);
	
	String productName=request.getParameter("name");
	int price=Integer.parseInt(request.getParameter("pPrice"));
	int pid=Integer.parseInt(request.getParameter("pId"));
	int quantity=Integer.parseInt(request.getParameter("quant"));
	System.out.println(productName);
	System.out.println(price);
	System.out.println(pid);

	Cart cartexist=cartDao.getTheCart(pid);
	
	
	if(cartexist==null)
	{
		Cart cm=new Cart();
		cm.setEmail(name);
		cm.setPrice(price);
		cm.setProd_id(pid);
		cm.setQuantity(quantity);
		cm.setProd_name(productName);
//		cm.setCartItemId(cartItemId);
		cartDao.saveTheCart(cm);
		
	}
	else if(cartexist!=null)
	{
		Cart cm = new Cart();
		cm.setCartItemId(cartexist.getCartItemId());
		cm.setEmail(name);
		cm.setPrice(price);
		cm.setProd_id(pid);
		cm.setProd_name(productName);
		cm.setQuantity(quantity);
		cartDao.updateTheCart(cm);
	}
	List<Cart> listCart=cartDao.retrieveTheCart(name);
	m.addAttribute("cartlist", listCart);
	return "Cart";
	
}
@RequestMapping(value="/cart",method=RequestMethod.GET)
public String showTheCart(HttpServletRequest request,Model m)
{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String name=authentication.getName();
	List<Cart> listCart=cartDao.retrieveTheCart(name);
	m.addAttribute("cartlist", listCart);
	return "Cart";
	
}
@RequestMapping(value="deleteCart{cartItemId}")
public String deleteTheCategory(@PathVariable("cartItemId")int prodId,Model m)
{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String name=authentication.getName();
	Cart cart=cartDao.getTheCart(prodId);
	cartDao.deleteTheCart(cart);
	List<Cart> listCart=cartDao.retrieveTheCart(name);
	m.addAttribute("cartlist", listCart);
	m.addAttribute("cartmodel", new Cart());
	return "Cart";
}
@RequestMapping(value = "/checkout")
public String checkout(HttpServletRequest request, Model m) {
	String gtot = request.getParameter("gtot");
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String name=authentication.getName();
	System.out.println(name);
	
	// System.out.println(gtot);
	m.addAttribute("gtot", gtot);
	RegistrationForm registrationForm=registrationDao.getTheRegistration(name);
	m.addAttribute("registrationForm",registrationForm);
	return "Checkout";
}

@RequestMapping(value = "/invoice")
public String invoice(HttpServletRequest request, Model m) {
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String name=authentication.getName();
	System.out.println(name);
	String gtot = request.getParameter("gtot");
	// System.out.println(gtot);
	m.addAttribute("gtot", gtot);
	RegistrationForm registrationForm=registrationDao.getTheRegistration(name);
	m.addAttribute("registrationForm",registrationForm);
	return "Invoice";
}
}
