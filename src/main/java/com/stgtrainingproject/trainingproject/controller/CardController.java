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

import com.stgtrainingproject.trainingproject.entities.Card;
import com.stgtrainingproject.trainingproject.services.CardService;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@PostMapping("/{userId}/card/add")
	public ResponseEntity<?> add(@PathVariable String userId, @RequestBody Card card) {
		try {
			this.cardService.addCard(userId, card);
			card.setUserId(userId);
			return ResponseEntity.status(HttpStatus.OK).body(card);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Card not added");
		}

	}

	@GetMapping("/{userId}/cards")
	public List<Card> getCards(@PathVariable String userId) {
		return this.cardService.getCards(userId);
	}

	@DeleteMapping("/{userId}/card/{cardNumber}/delete")
	public ResponseEntity<?> removeCard(@PathVariable String userId, @PathVariable Long cardNumber) {
		try {
			this.cardService.removeCard(userId, cardNumber);
			return ResponseEntity.status(HttpStatus.OK).body("Card Removed");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Card not removed");
		}
	}
}
