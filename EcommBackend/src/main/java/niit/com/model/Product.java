package niit.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product 
{
	@Id
	private int id;
	private String shoes;
	private String books;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShoes() {
		return shoes;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}

	}

