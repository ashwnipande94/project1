package com.handbags.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.handbags.spring.Service.SupplierService;
import com.handbags.spring.model.Supplier;
@Controller
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/supplier")
	public String getSupplier(Model model) {
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", supplierService.getList());
		model.addAttribute("supplierList", supplierService.getJsonList());
		return "Supplier";
	}
	
	@RequestMapping("/addSupplier")
	public String addSupplierDAO(@ModelAttribute("supplier")Supplier supplier) {
		supplierService.addSupplierDAO(supplier);
		return "redirect:/supplier";
	}
	@RequestMapping("editSupplier-{SupplierId}")
	public String editSupplier(Model model,@PathVariable("SupplierId") int SupplierId){
	model.addAttribute("supplier", supplierService.getSupplierById(SupplierId))	;
	return "Supplier";
		
	}
	
	@RequestMapping("/deleteSupplier-{SupplierId}")
	public String deleteSupplier(@PathVariable("SupplierId") int SupplierId){
		supplierService.deleteSupplier(SupplierId);
	return "redirect:/supplier";
		
	}



}
