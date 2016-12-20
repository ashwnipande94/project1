package com.handbags.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.handbags.spring.Service.CategoryService;
import com.handbags.spring.Service.SubcategoryService;
import com.handbags.spring.model.Category;
import com.handbags.spring.model.Subcategory;

@Controller
public class SubcategoryController {
	
@Autowired
SubcategoryService subcategoryService;
	@Autowired
CategoryService categoryService;
	@RequestMapping("/Subcategory")
	public String getCategory(Model model) {
		model.addAttribute("subcategory", new Subcategory());
		model.addAttribute("category",new Category());
		model.addAttribute("subcategoryList", subcategoryService.getList());
		model.addAttribute("categoryList",categoryService.getList());
		model.addAttribute("subcategoryList", subcategoryService.getJsonList());
		return "Subcategory";
	}
	
	@RequestMapping("/addSubcategory")
	public String addSubcategoryDAO(@ModelAttribute("subcategory") Subcategory subcategory) {
		
		Category category=categoryService.getCategoryByName(subcategory.getCategory().getCategoryName());
		subcategory.setCategory(category);
		subcategory.setCategoryId(category.getCategoryId());
		subcategoryService.addSubcategoryDAO(subcategory);
		return "redirect:/Subcategory";

	}
	@RequestMapping("editSubcategory-{subcategoryId}")
	public String editSubcategory(Model model,@PathVariable("subcategoryId") int subcategoryId){
	model.addAttribute("subcategory", subcategoryService.getSubcategoryById(subcategoryId))	;
	model.addAttribute("categoryList",categoryService.getList());

	return "Subcategory";
		
	}
	
	@RequestMapping("/deleteSubcategory-{subcategoryId}")
	public String deleteSubcategory(@PathVariable("subcategoryId") int subcategoryId){
	subcategoryService.deleteSubcategory(subcategoryId);
	return "redirect:/Subcategory";
		
	}

}
