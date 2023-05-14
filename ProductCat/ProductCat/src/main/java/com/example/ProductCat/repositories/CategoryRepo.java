package com.example.ProductCat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductCat.models.Category;
import com.example.ProductCat.models.Product;
@Repository
public interface CategoryRepo extends CrudRepository <Category,Long> {
	List<Category> findAll();
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}