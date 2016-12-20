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

import com.handbags.spring.Service.BrandService;
import com.handbags.spring.Service.CategoryService;
import com.handbags.spring.Service.ProductServices;
import com.handbags.spring.Service.SubcategoryService;
import com.handbags.spring.Service.SupplierService;
import com.handbags.spring.model.Brand;
import com.handbags.spring.model.Category;
import com.handbags.spring.model.Product;
import com.handbags.spring.model.Subcategory;
import com.handbags.spring.model.Supplier;

@Controller
public class ProductController {

	
	Product product;
	@Autowired
	ProductServices productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubcategoryService subcategoryService;
	@Autowired
	BrandService brandService;
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/product")
	public String getProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("category",new Category());
		model.addAttribute("subcategory",new Subcategory());
		model.addAttribute("brand",new Brand());
		model.addAttribute("supplier",new Supplier());

		model.addAttribute("productList", productService.getList());
		model.addAttribute("categoryList",categoryService.getList());
		model.addAttribute("subcategoryList",subcategoryService.getList());
		model.addAttribute("brandList",brandService.getList());
		model.addAttribute("supplierList",supplierService.getList());
		model.addAttribute("productList", productService.getJsonList());
		
		return "Product";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct( @Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		
		if(result.hasErrors()){
			
			return "Product";	}
			
		else{
		
		Category category=categoryService.getCategoryByName(product.getCategory().getCategoryName());
		product.setCategory(category);
		product.setCategoryId(category.getCategoryId());
		
		Subcategory subcategory=subcategoryService.getSubcategoryByName(product.getSubcategory().getSubcategoryName());
		product.setSubcategory(subcategory);
		product.setSubcategoryId(subcategory.getSubcategoryId());
		
		Brand brand=brandService.getBrandByName(product.getBrand().getBrandName());
		product.setBrand(brand);
		product.setBrandId(brand.getBrandId());
		
		Supplier supplier=supplierService.getSupplierByName(product.getSupplier().getSupplierName());
		product.setSupplier(supplier);
		product.setSupplierId(supplier.getSupplierId());
	
		
		
	
        String path="G:\\TheBolsoVilla\\src\\main\\webapp\\resources\\images";
		path=path+String.valueOf(product.getProductId())+".jpg";
	     File f =new File(path);
		System.out.println("path is" +path);
		MultipartFile filedet=product.getProductImage();
	
		try
		{
			
			byte[]bytes=filedet.getBytes();
			FileOutputStream fos= new FileOutputStream(f);
			BufferedOutputStream bs=new BufferedOutputStream(fos);
			bs.write(bytes);
			bs.close();
			System.out.println("File Uploaded Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		}
		
		
		
		productService.addProduct(product);
		return "redirect:/product";
		}
		
	}
			
			
		
	@RequestMapping("editProduct-{productId}")
	public String editProduct(Model model,@PathVariable("productId") int productId){
	model.addAttribute("product", productService.getProductById(productId))	;
	model.addAttribute("categoryList",categoryService.getList());
	model.addAttribute("subcategoryList",subcategoryService.getList());
	model.addAttribute("brandList",brandService.getList());
	model.addAttribute("supplierList",supplierService.getList());
	return "Product";
		
	}
	
	@RequestMapping("/deleteProduct-{productId}")
	public String deleteProduct(@PathVariable("productId") int productId){
		productService.deleteProduct(productId);
	return "redirect:/product";
		
	}



}
