package com.stgtrainingproject.trainingproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stgtrainingproject.trainingproject.dao.CardDao;
import com.stgtrainingproject.trainingproject.dao.UserRepository;
import com.stgtrainingproject.trainingproject.entities.Card;
import com.stgtrainingproject.trainingproject.entities.User;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Card> getCards(String userId) {
		int flag = 0;
		List<User> users = userRepository.findAll();
		List<Card> card = cardDao.findAll();
		List<Card> resultList = new ArrayList<>();
		for (User item : users) {
			if (item.getUserId().equals(userId)) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			for (Card item : card) {
				if (item.getUserId().equals(userId)) {
					resultList.add(item);
				}
			}

			return resultList;
		}
		return null;

	}

	@Override
	public Card addCard(String userId, Card card) {
		int flag = 0;
		List<User> users = userRepository.findAll();
		Card cd = new Card();
		cd.setUserId(userId);
		cd.setCardNumber(card.getCardNumber());
		cd.setNameOnCard(card.getNameOnCard());
		cd.setExpiryMonth(card.getExpiryMonth());
		cd.setExpiryYear(card.getExpiryYear());
		for (User item : users) {
			if (item.getUserId().equals(userId)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return cardDao.save(cd);
		}
		return new Card();
	}

	@Override
	public Card removeCard(String userId, long cardNumber) {
		int flag = 0;
		List<User> users = userRepository.findAll();
		List<Card> card = cardDao.findAll();
		Card cd = null;
		for (User item : users) {
			if (item.getUserId().equals(userId)) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			for (Card item : card) {
				if (item.getUserId().equals(userId) && item.getCardNumber() == cardNumber) {
					cd = item;
					break;
				}
			}

			cardDao.delete(cd);
			return cd;
		}

		return new Card();
	}

}
