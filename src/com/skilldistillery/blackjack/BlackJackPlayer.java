package com.skilldistillery.blackjack;

import com.skilldistillery.gameparticipants.CardPlayer;

public class BlackJackPlayer extends CardPlayer {
	
	public void hit(BlackJackDealer dealer, BlackJackPlayer deltTo) {
		dealer.dealCard(deltTo);
	} 
}
