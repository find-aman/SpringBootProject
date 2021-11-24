package com.stgtrainingproject.trainingproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(nullable = false)
	private String userId;
	@Column(unique = true, nullable = false)
	private long cardNumber;
	@Column(nullable = false)
	private String nameOnCard;
	@Column(nullable = false)
	private int expiryMonth;
	@Column(nullable = false)
	private int expiryYear;

	public Card() {
		super();
	}

	public Card(int id, String userId, long cardNumber, String nameOnCard, int expiryMonth, int expiryYear) {
		super();
		Id = id;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
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

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	@Override
	public String toString() {
		return "Card [Id=" + Id + ", userId=" + userId + ", cardNumber=" + cardNumber + ", nameOnCard=" + nameOnCard
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + "]";
	}

}
