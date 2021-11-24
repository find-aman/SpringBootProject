package com.stgtrainingproject.trainingproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stgtrainingproject.trainingproject.dao.UserRepository;
import com.stgtrainingproject.trainingproject.dao.WishlistDao;
import com.stgtrainingproject.trainingproject.entities.User;
import com.stgtrainingproject.trainingproject.entities.Wishlist;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistDao wishlistDao;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Wishlist> getWishlist(String userId) {

		try {

			int flag = 0;
			List<User> users = userRepository.findAll();

			List<Wishlist> wishlist = wishlistDao.findAll();
			List<Wishlist> resultList = new ArrayList<>();

			for (User item : users) {
				if (item.getUserId().equals(userId)) {
					flag = 1;
					break;
				}
			}

			if (flag == 1) {
				for (Wishlist item : wishlist) {
					if (item.getUserId().equals(userId)) {
						resultList.add(item);
					}
				}

				return resultList;
			}
			return null;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Wishlist addProduct(String userId, String productName, Wishlist wishlist) {

		List<User> users = userRepository.findAll();
		int flag = 0;
		Wishlist wl = new Wishlist();
		wl.setUserId(userId);
		wl.setProductName(productName);
		wl.setDisplayName(wishlist.getDisplayName());
		wl.setCategory(wishlist.getCategory());
		wl.setShortDescription(wishlist.getShortDescription());

		for (User item : users) {
			if (item.getUserId().equals(userId)) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			return wishlistDao.save(wl);
		}
		return new Wishlist();

	}

	@Override
	public Wishlist removeProduct(String userId, String productName) {

		List<User> users = userRepository.findAll();
		int flag = 0;
		List<Wishlist> wishlist = wishlistDao.findAll();
		Wishlist wl = null;

		for (Wishlist item : wishlist) {
			if (item.getUserId().equals(userId) && item.getProductName().equals(productName)) {
				wl = item;
				break;
			}
		}

		for (User item : users) {
			if (item.getUserId().equals(userId)) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			wishlistDao.delete(wl);
			return wl;
		}
		return new Wishlist();
	}

}
