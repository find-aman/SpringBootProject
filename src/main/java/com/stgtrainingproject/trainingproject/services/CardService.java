package com.stgtrainingproject.trainingproject.services;

import java.util.List;

import com.stgtrainingproject.trainingproject.entities.Card;

public interface CardService {

	public List<Card> getCards(String userId);

	public Card addCard(String userId, Card card);

	public Card removeCard(String userId, long cardNumber);

}
