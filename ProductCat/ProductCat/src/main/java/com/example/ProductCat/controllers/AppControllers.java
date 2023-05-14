package com.example.ProductCat.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProductCat.models.Category;
import com.example.ProductCat.models.Product;
import com.example.ProductCat.servicies.CategoryServices;
import com.example.ProductCat.servicies.ProductServices;

import jakarta.validation.Valid;
@Controller
public class AppControllers {
private final ProductServices proServices;
private final CategoryServices catServices;
public AppControllers(ProductServices proServices, CategoryServices catServices) {
	super();
	this.proServices = proServices;
	this.catServices = catServices;
}
@RequestMapping("/")
public String homePage(Model model) {
	model.addAttribute("product",proServices.allProduct());
	model.addAttribute("category",catServices.allCategory());
	return "home.jsp";
	
}
// add  a product 
@RequestMapping("/products/new")
public String renderProduct(@ModelAttribute("fatoom")Product product) {
	return "newproduct.jsp";
}
@PostMapping("/products/new")
public String addProduct(@Valid @ModelAttribute("fatoom")Product product,BindingResult result) {
	if(result.hasErrors()) {
		return "newproduct.jsp";
	}
	proServices.creatProduct(product);
	return "redirect:/" ;
}
@RequestMapping("/category/new")
public String renderCategory(@ModelAttribute("fatoom")Category category){
	return "newcateory.jsp";
	
}
@PostMapping("/category/new")
public String addCategory(@Valid @ModelAttribute("fatoom")Category category,BindingResult result){
	if(result.hasErrors()) {
		return "newcateory.jsp";
	}
	catServices.creatCategory(category);
	return "redirect:/" ;
}
//add product to category 
@RequestMapping("/products/new/{id}")
public String addProductToCat(@PathVariable("id") Long id ,Model model) {
	Product pro=proServices.retriveAProduct(id);
	model.addAttribute("pro1",pro);
	model.addAttribute("category",catServices.catNotContainsPro(pro));
	return "productdetails.jsp";
	
}
@PostMapping("/products/new/{id}")
public String submitProductToForm(@PathVariable("id") Long id,@RequestParam("category") Long Cat_id,Model model) {
	Category category=catServices.retriveACategory(Cat_id);
	Product pro=proServices.retriveAProduct(id);
	List<Category> cat=pro.getCategories();
	cat.add(category);
	pro.setCategories(cat);
	proServices.updatProduct(pro);
	return "redirect:/";
		
}
// added category to product 
@RequestMapping("/category/new/{id}")
public String addCategoryToProduct(@PathVariable("id") Long id ,Model model) {
	Category cat =catServices.retriveACategory(id);
	model.addAttribute("cat1",cat);
	model.addAttribute("product",proServices.proNotContainsCat(cat));
	return "catdetails.jsp";
}
@PostMapping("/category/new/{id}")
public String submitCategoryToForm(@PathVariable("id") Long id,@RequestParam("product") Long prod_id,Model model) {
	Category category =catServices.retriveACategory(id);
	Product pro=proServices.retriveAProduct(prod_id);
	List<Product> prod=category.getProducts();
	prod.add(pro);
	category.setProducts(prod);
	catServices.updateCategory(category);

	return "redirect:/";
	
}
}


