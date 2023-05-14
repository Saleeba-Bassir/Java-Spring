package com.example.ProductCat.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ProductCat.models.Category;
import com.example.ProductCat.models.Product;
import com.example.ProductCat.repositories.ProductRepo;

@Service
public class ProductServices {
private  final ProductRepo productRepo;

public ProductServices(ProductRepo productRepo) {
	super();
	this.productRepo = productRepo;
}
// return all product 
public List<Product> allProduct(){
	return productRepo.findAll();
}
// create product
public Product creatProduct(Product product) {
	return productRepo.save(product);
}
// Retrieve a product
public Product retriveAProduct(Long id) {
	Optional<Product> product=productRepo.findById(id);
	if (product.isPresent()) {
		return product.get();
	}
	return null;
}
public List<Product> proNotContainsCat(Category category){
	return productRepo.findByCategoriesNotContains(category);
	
}
public void updatProduct(Product product) {
	productRepo.save(product);
}


}
