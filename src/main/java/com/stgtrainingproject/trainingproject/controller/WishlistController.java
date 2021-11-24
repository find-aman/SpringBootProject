package com.stgtrainingproject.trainingproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stgtrainingproject.trainingproject.entities.Wishlist;
import com.stgtrainingproject.trainingproject.services.WishlistService;

@RestController
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@PostMapping("/{userId}/wishlist/{productName}/add")
	public ResponseEntity<?> add(@PathVariable String userId, @PathVariable String productName,
			@RequestBody Wishlist wishlist) {

		try {
			this.wishlistService.addProduct(userId, productName, wishlist);
			wishlist.setUserId(userId);
			wishlist.setProductName(productName);
			return ResponseEntity.status(HttpStatus.OK).body(wishlist);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not added");
		}

	}

	@GetMapping("/{userId}/wishlist")
	public List<Wishlist> view(@PathVariable String userId) {

		return this.wishlistService.getWishlist(userId);
	}

	@DeleteMapping("/{userId}/wishlist/{productName}/remove")
	public ResponseEntity<?> remove(@PathVariable String userId, @PathVariable String productName) {
		try {
			this.wishlistService.removeProduct(userId, productName);
			return ResponseEntity.status(HttpStatus.OK).body("Product Removed");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not removed");
		}
	}

}
