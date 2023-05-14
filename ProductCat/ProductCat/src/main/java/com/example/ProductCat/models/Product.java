package com.example.ProductCat.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@NotNull
	private String name ;
	@NotNull
	private String description;
	@NotNull
	private float price;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="categories_products",
	joinColumns=@JoinColumn(name="product_id"),
	inverseJoinColumns=@JoinColumn(name="category_id"))
	private List <Category> categories;
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Product() {
	
	}
	
	public Product(@NotNull String name, @NotNull String description, @NotNull float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	// other getters and setters removed for brevity
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
//	public void addcategory(Category category) {
//		this.categories.add(category);
//	}
	}

