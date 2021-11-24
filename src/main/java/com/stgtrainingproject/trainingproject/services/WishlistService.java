package com.stgtrainingproject.trainingproject.services;

import java.util.List;

import com.stgtrainingproject.trainingproject.entities.Wishlist;

public interface WishlistService {

	public List<Wishlist> getWishlist(String userId);

	public Wishlist addProduct(String userId, String productName, Wishlist wishlist);

	public Wishlist removeProduct(String userId, String productName);

}
