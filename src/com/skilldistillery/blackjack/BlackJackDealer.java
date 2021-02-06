package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.gameparticipants.CardPlayer;

public class BlackJackDealer extends CardPlayer {
	private Deck deck = new Deck();

	public void dealCard(CardPlayer dealtTo) {
		dealtTo.getHand().addCard(deck.dealCard());
//		add(deck.dealCard());
	}

	public void hitOrStand() {
		// Hit
		if (hand.getValue() < 17) {
			hand.getHand().add(deck.dealCard());
		} else {

		}

	}

	public void cardsOnTable() {
		int i = 0;
		for (Card card : hand.getHand()) {
			if (i == 0) {
				System.out.print("One Card Face Down. ");
			} else {
				System.out.print("The " + card + ". ");
			}
			i++;
		}
		System.out.println("\nDealer showing value of: " + (hand.getValue() - (hand.getHand().get(0).getValue())));
	}

}
