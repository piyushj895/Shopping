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
	@RequestMapping(value="/supplier")
	public String showTheSupplier(Model m)
	{
	List<Supplier> listSupplier=supplierDao.retrieveSupplier();
	m.addAttribute("supplierList",listSupplier);
	m.addAttribute("suppliermodel",new Supplier());
	return "Supplier";
	}
	@RequestMapping(value="/showTheSupplier")
	public String saveTheSupplier(@ModelAttribute Supplier supplier,Model m)
	{
		supplierDao.saveTheSupplier(supplier);
		List<Supplier> listsupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList", listsupplier);
		m.addAttribute("suppliermodel", new Supplier());
		
		return "Supplier";
		
	}
	@RequestMapping(value="updateSupplier/{id}")
	public String updateSupplier(@PathVariable("id")int suppId,Model m)
	{
		Supplier supplier=supplierDao.getTheSupplier(suppId);
		m.addAttribute("suppliermodel", supplier);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList", listSupplier);
		return "Supplier";
	}
	@RequestMapping(value="/UpdateSupplier")
	public String updateMySupplier(@ModelAttribute Supplier supplier,Model m)
	{
		supplierDao.updateTheSupplier(supplier);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppliermodel", new Supplier());
		return "redirect:/supplier";
	}
	@RequestMapping(value="deleteSupplier/{id}")
	public String deleteTheSupplier(@PathVariable("id")int suppId,Model m)
	{
		Supplier supplier=supplierDao.getTheSupplier(suppId);
		supplierDao.deleteTheSupplier(supplier);
		List<Supplier> listsupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listsupplier);
		m.addAttribute("suppliermodel", new Supplier());
		return "Supplier";
	}
	
}
