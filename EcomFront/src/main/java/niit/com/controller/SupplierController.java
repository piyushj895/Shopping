package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import niit.com.dao.SupplierDao;
import niit.com.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping(value="/adminsupplier")
	public String showTheSupplier(Model m)
	{
	List<Supplier> listSupplier=supplierDao.retrieveSupplier();
	m.addAttribute("supplierList",listSupplier);
	m.addAttribute("suppliermodel",new Supplier());
	return "Supplier";
	}
	@RequestMapping(value="/adminshowTheSupplier")
	public String saveTheSupplier(@ModelAttribute Supplier supplier,Model m)
	{
		supplierDao.saveTheSupplier(supplier);
		List<Supplier> listsupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList", listsupplier);
		m.addAttribute("suppliermodel", new Supplier());
		
		return "Supplier";
		
	}
	@RequestMapping(value="adminupdateSupplier{sup_id}")
	public String updateSupplier(@PathVariable("sup_id")int suppId,Model m)
	{
		Supplier supplier=supplierDao.getTheSupplier(suppId);
		m.addAttribute("suppliermodel", supplier);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList", listSupplier);
		return "SupplierUpdate";
	}
	@RequestMapping(value="/adminUpdateSupplier")
	public String updateMySupplier(@ModelAttribute Supplier supplier,Model m)
	{
		supplierDao.updateTheSupplier(supplier);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppliermodel", new Supplier());
		return "Supplier";
	}
	@RequestMapping(value="admindeleteSupplier{sup_id}")
	public String deleteTheSupplier(@PathVariable("sup_id")int suppId,Model m)
	{
		Supplier supplier=supplierDao.getTheSupplier(suppId);
		supplierDao.deleteTheSupplier(supplier);
		List<Supplier> listsupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listsupplier);
		m.addAttribute("suppliermodel", new Supplier());
		return "Supplier";
	}
	
}
