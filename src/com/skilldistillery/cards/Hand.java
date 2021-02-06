package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public Hand() {
		super();
	}

	public Hand(List<Card> hand) {
		super();
		this.hand = hand;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clearHand() {
		hand.clear();
	}

	public List<Card> getHand() {
		return hand;
	}

	public abstract int getValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand has: ");
		for (Card card : hand) {
			builder.append(card).append(", ");
		}

		return builder.toString();
	}

}
