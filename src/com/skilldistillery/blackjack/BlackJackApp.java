package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp ba = new BlackJackApp();
		ba.run();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		boolean playAgain = true;
		while (playAgain) {
			BlackJackDealer dealer = new BlackJackDealer();
			BlackJackPlayer player = new BlackJackPlayer();
			boolean playerTurn = true;
			int playerSelection = 0;
			
			welcome();
			dealForTwo(dealer, player);
			System.out.println("Dealer is showing: ");
			dealer.cardsOnTable();
			System.out.println("\nYou have the: ");
			player.showHand();
			while(playerTurn) {
				hitOrStayTxt();
				try{
					playerSelection = kb.nextInt();
					kb.nextLine();
				}catch(InputMismatchException e) {
					System.out.println("You must enter either 1 or 2\n");
					kb.nextLine();
					continue;
				}
				if (playerSelection != 1 && playerSelection != 2) {
					System.out.println("You must enter either 1 or 2\n");
					continue;
				}
				if (playerSelection == 2) {
					playerTurn = false;
				} else {
					player.hit(dealer, player);
					System.out.println("\nYou now have: ");
					player.showHand();
					System.out.print("\nYou hand value is: ");
					
					
				}
			}

			playAgain = false;
		}
	}

	private void welcome() {
		System.out.println("Welcome to Webel's Wondrous casion!");
		System.out.println("We welcome you to sait your wonderlust with this wonderful local.");
		System.out.println(
				"It appears you've bullied, beguiled, or bought your way into the most illustrious Blackjack Game around.");
		System.out.println("Welcome, welcome, welcome! Please, have a seat, order a drink , and enjoy the game. \n"
				+ "Oh, and don't forget, tip your dealer!\n\n");
	}
	private void hitOrStayTxt() {
		System.out.println("Dealer: Would you like to hit or stay?");
		System.out.println("1.) Hit!");
		System.out.println("2.) Stay.");
	}
	private void dealForTwo(BlackJackDealer dealer, BlackJackPlayer player) {
		dealer.dealCard(dealer);
		dealer.dealCard(player);
		dealer.dealCard(dealer);
		dealer.dealCard(player);
	}
}
