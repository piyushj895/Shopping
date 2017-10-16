package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
return "Supplier";
}
}

