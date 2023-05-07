package com.example.demo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="burgers")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String burger_name;
    @NotNull
    @Size(min = 5, max = 200)
    private String restaurant_name;
    @NotNull
    @Min(0)
    @Max(5)
    private Long rating;

    @NotNull
    @Size(min = 5, max = 200)
    private String notes;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {
    }
    public Burger(String burger_name, String restaurant_name, Long rating, String notes) {
        this.burger_name = burger_name;
        this.restaurant_name = restaurant_name;
        this.rating = rating;
        this.notes = notes;
    }

    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBurger_name() {
		return burger_name;
	}
	public void setBurger_name(String burger_name) {
		this.burger_name = burger_name;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
}


