package com.stgtrainingproject.trainingproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stgtrainingproject.trainingproject.entities.Wishlist;

public interface WishlistDao extends JpaRepository<Wishlist, Integer > {

}
