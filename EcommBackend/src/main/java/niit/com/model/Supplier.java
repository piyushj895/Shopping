package niit.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Supplier 
{
	@Id
	private int id;
	private String sup_name;
	private String sup_email;
	private String sup_contact;
	private String sup_address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getSup_email() {
		return sup_email;
	}
	public void setSup_email(String sup_email) {
		this.sup_email = sup_email;
	}
	public String getSup_contact() {
		return sup_contact;
	}
	public void setSup_contact(String sup_contact) {
		this.sup_contact = sup_contact;
	}
	public String getSup_address() {
		return sup_address;
	}
	public void setSup_address(String sup_address) {
		this.sup_address = sup_address;
	}
	
		
}

