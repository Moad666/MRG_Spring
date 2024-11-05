package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="average_rating")
	private float averageRating;
	
	@Column(name="image")
	private String image;
	
	@Column(name="phone")
	private int phone;
	
	@Column(name="ouvert")
	private int ouvert;
	
	@Column(name="fermer")
	private int fermer;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @JsonBackReference
    @ToString.Exclude
    private City city;
	
	public Restaurant() {}

	public Restaurant(int id, String name, String description, String location, 
			float averageRating, String image,int phone, int ouvert, int fermer ,  City city) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.averageRating = averageRating;
		this.image = image;
		this.phone = phone;
		this.ouvert = ouvert;
		this.fermer = fermer;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getOuvert() {
		return ouvert;
	}

	public void setOuvert(int ouvert) {
		this.ouvert = ouvert;
	}

	public int getFermer() {
		return fermer;
	}

	public void setFermer(int fermer) {
		this.fermer = fermer;
	}
	
	
}
