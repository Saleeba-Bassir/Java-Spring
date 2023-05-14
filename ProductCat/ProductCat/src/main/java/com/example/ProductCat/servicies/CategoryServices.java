package com.example.ProductCat.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ProductCat.models.Category;
import com.example.ProductCat.models.Product;
import com.example.ProductCat.repositories.CategoryRepo;


@Service
public class CategoryServices {
	private  final CategoryRepo categoryRepo;

	public CategoryServices(CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}
	// return all Category 
	public List<Category> allCategory(){
		return categoryRepo.findAll();
	}
	// create Category
	public Category creatCategory(Category category) {
		return categoryRepo.save(category);
	}
	// Retrieve a Category
	public Category retriveACategory(Long id) {
		Optional<Category> category=categoryRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		return null;
	}
public List <Category> catNotContainsPro(Product product){
	return categoryRepo.findByProductsNotContains(product) ;
	
}
public void updateCategory(Category category) {
	categoryRepo.save(category);
}
}
