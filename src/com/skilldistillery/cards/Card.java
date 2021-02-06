package com.skilldistillery.cards;

public class Card {
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank.toString().toLowerCase()).append(" of ").append(suit);
		return builder.toString();
	}
	public Suit getSuit() {
		return suit;
	}
	public int getValue() {
		return rank.getValue();
	}
	
}
