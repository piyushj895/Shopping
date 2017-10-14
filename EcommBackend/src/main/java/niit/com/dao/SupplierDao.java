package niit.com.dao;



import java.util.List;

import niit.com.model.Supplier;



public interface SupplierDao 
{
	public void saveTheSupplier(Supplier supplier);
	public void updateTheSupplier(Supplier supplier);
	public void deleteTheSupplier(Supplier supplier);
	public Supplier getTheSupplier(int supplierId);
	public List<Supplier> retrieveSupplier();

}
