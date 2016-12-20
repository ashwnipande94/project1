package com.handbags.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
    private int categoryId;
	@NotEmpty
	@Pattern(regexp="^[A-Za-z+]+[0-9+]*$",message="categoryname should start with alphabet")
	private String categoryName;
	
	@NotEmpty(message="Enter valid email address")
	private String categoryDescription;
	
	@Transient
	MultipartFile categoryImage;

	
	public MultipartFile getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
}