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
m.addAttribute("registrationmodel",new RegistrationForm());
return "Registration";
}
@RequestMapping(value="/showTheRegistration")
public String saveTheRegistration(@ModelAttribute RegistrationForm registrationForm,Model m)
{
	if(registrationForm.getPassword().equals(registrationForm.getCpassword()))
	{
		registrationDao.saveTheRegistration(registrationForm);
	}

	else
	{
		m.addAttribute("nomatch", "nomatch");
	}
		m.addAttribute("registrationmodel", new RegistrationForm());
	return "Registration";


}

}
