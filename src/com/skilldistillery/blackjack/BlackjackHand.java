package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}

	@Override
	public int getValue() {
		int handVal = 0;
		
		for (Card card : hand) {
			handVal += card.getValue();
		}
		
		return handVal;
	}
	public boolean isBlackJack() {
		if (getValue() == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isBustJack() {
		if (getValue() > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	public void showHand() {
		for (Card card : hand) {
			System.out.print("The " + card + ". ");
		}
	}

}
