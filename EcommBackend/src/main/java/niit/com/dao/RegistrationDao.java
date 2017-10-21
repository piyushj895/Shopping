package niit.com.dao;

import java.util.List;

import niit.com.model.RegistrationForm;

public interface RegistrationDao 
{
public void saveTheRegistration(RegistrationForm registrationForm);
public void updateTheRegistration(RegistrationForm registrationForm);
public void deleteTheRegistration(RegistrationForm registrationForm);
public RegistrationForm getTheRegistration(String registrationemail);
public List<RegistrationForm> retrieveRegistrationForm();

}
