package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	public Deck() {
		this.deck = buildDeck();
	}

	private List<Card> buildDeck() {
		List<Card> deck = new ArrayList<>();
		Rank[] cardWieght = Rank.values();
		Suit[] suits = Suit.values();
		for (Suit suit : suits) {
			for (Rank wieght : cardWieght) {
				deck.add(new Card(suit, wieght));
			}
		}

		return deck;
	}
	public int checkDeckSize() {
		int deckSize = (deck.size()-1);
		return deckSize;
	}
	public Card dealCard() {
		Card deltCard = deck.remove(deck.size()-1);
		return deltCard;
	}
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
