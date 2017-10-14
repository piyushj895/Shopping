package niit.com.dao;

import java.util.List;

import niit.com.model.Category;

public interface Dao 
{
public void saveTheCategory(Category category);
public void updateTheCategory(Category category);
public void deleteTheCategory(Category category);
public Category getTheCategory(int catId);
public List<Category> retrieveCategory();
}
