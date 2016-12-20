package com.handbags.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.handbags.spring.Service.BrandService;
import com.handbags.spring.model.Brand;


@Controller
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@RequestMapping("/brand")
	public String getBrand(Model model) {
		model.addAttribute("brand", new Brand());
		model.addAttribute("brandList", brandService.getList());
		model.addAttribute("brandList", brandService.getJsonList());
		return "Brand";
	}
	
	@RequestMapping("/addBrand")
	public String addBrand(@ModelAttribute("brand")Brand brand) {
		brandService.addBrand(brand);
		return "redirect:/brand";
	}
	@RequestMapping("editBrand-{brandId}")
	public String editBrand(Model model,@PathVariable("brandId") int brandId){
	model.addAttribute("brand", brandService.getBrandById(brandId))	;
	return "Brand";
		
	}
	
	@RequestMapping("/deleteBrand-{brandId}")
	public String deleteBrand(@PathVariable("brandId") int brandId){
		brandService.deleteBrand(brandId);
	return "redirect:/brand";
		
	}


}
