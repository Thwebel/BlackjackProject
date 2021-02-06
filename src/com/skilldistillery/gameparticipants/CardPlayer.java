package com.skilldistillery.gameparticipants;

import java.util.List;

import com.skilldistillery.blackjack.BlackjackHand;
import com.skilldistillery.cards.Card;

public abstract class CardPlayer {
//	protected List<Card> hand = new ArrayList<>();
	protected BlackjackHand hand = new BlackjackHand();
	
//	protected int money;
	
//  bet()	
	
	public void showHand() {
		for (Card card : hand.getHand()) {
			System.out.println(card);
		}
	}

	public BlackjackHand getHand() {
		return hand;
	}
	
	

}
