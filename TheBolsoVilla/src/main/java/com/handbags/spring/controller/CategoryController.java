package com.handbags.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.handbags.spring.Service.CategoryService;
import com.handbags.spring.model.Category;

@Controller
public class CategoryController {
	
	Category category;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/category")
	public String getCategory(Model model) {
		model.addAttribute("category", new Category());
//		model.addAttribute("categoryList", categoryService.getList());
		model.addAttribute("categoryList", categoryService.getJsonList());
		return "Category";
	}
	
	@RequestMapping("/addCategory")
	public String addCategory( @Valid @ModelAttribute("category") Category category,BindingResult result) {
	
		if(result.hasErrors()){
			return "Category";	
		}
		else{
			categoryService.addCategory(category);	
			return "redirect:/category";
		}
		
		}
		

	@RequestMapping("editCategory-{categoryId}")
	public String editCategory(Model model,@PathVariable("categoryId") int categoryId){
	model.addAttribute("category", categoryService.getCategoryById(categoryId))	;
		
	
	return "Category";
		
	}
	
	@RequestMapping("/deleteCategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId){
	categoryService.deleteCategory(categoryId);
	return "redirect:/category";
		
	}

	
}
