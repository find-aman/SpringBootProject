package com.stgtrainingproject.trainingproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(nullable = false)
	private String userId;
	@Column(unique = true, nullable = false)
	private String productName;
	@Column(nullable = false)
	private String displayName;
	@Column(nullable = false)
	private String shortDescription;
	@Column(nullable = false)
	private String category;

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wishlist(int id, String userId, String productName, String displayName, String shortDescription,
			String category) {
		super();
		Id = id;
		this.userId = userId;
		this.productName = productName;
		this.displayName = displayName;
		this.shortDescription = shortDescription;
		this.category = category;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Wishlist [Id=" + Id + ", userId=" + userId + ", productName=" + productName + ", displayName="
				+ displayName + ", shortDescription=" + shortDescription + ", category=" + category + "]";
	}

}
