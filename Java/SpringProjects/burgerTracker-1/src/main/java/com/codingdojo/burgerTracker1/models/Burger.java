package com.codingdojo.burgerTracker1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
	public Burger() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min=1, max=255, message="Burger name must not be null")
	private String burgername;
	
	
	@NotNull
	@Size(min=1, max=255, message="Restaurant name must not be null")
	private String restaurantname;
	
	
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
	

	@NotNull
	@Size(min=1, max=255, message="Notes must not be null")
	private String notes;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger(String burgername, String restaurantname, Integer rating, String notes){
    	
    		this.burgername = burgername;
    		this.restaurantname = restaurantname;
    		this.rating = rating;
    		this.notes = notes;
    	}
    
  
   

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getBurgername() {
		return burgername;
	}




	public void setBurgername(String burgername) {
		this.burgername = burgername;
	}




	public String getRestaurantname() {
		return restaurantname;
	}




	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}




	public Integer getRating() {
		return rating;
	}




	public void setRating(Integer rating) {
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




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}


