package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import niit.com.dao.RegistrationDao;
import niit.com.model.RegistrationForm;

@Controller
public class RegistrationController 
{
@Autowired
RegistrationDao registrationDao;
@RequestMapping(value="/registration")
public String showTheRegistration(Model m)
{
List<RegistrationForm> listRegistration=registrationDao.retrieveRegistrationForm();
m.addAttribute("registrationList",listRegistration);
m.addAttribute("registrationmodel",new RegistrationForm());
return "Registration";
}
@RequestMapping(value="/showTheRegistration")
public String saveTheRegistration(@ModelAttribute RegistrationForm registrationForm,Model m)
{
	registrationDao.saveTheRegistration(registrationForm);
	List<RegistrationForm> listRegistration=registrationDao.retrieveRegistrationForm();
	m.addAttribute("registrationList", listRegistration);
	m.addAttribute("registrationmodel", new RegistrationForm());
	
	return "Registration";

}

}
