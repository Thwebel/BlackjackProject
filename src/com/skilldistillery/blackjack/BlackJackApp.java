package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.gameparticipants.CardPlayer;

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
			boolean dealerTurn = true;
			boolean checkWinner = false;
			int playerSelection = 0;

			welcome();
			dealForTwo(dealer, player);

			System.out.println("Dealer is showing: ");
			dealer.cardsOnTable();
			System.out.println("\nYou have: ");
			player.showHand();
			System.out.print("\nYour hand value is: ");
			System.out.println(player.getHand().getValue() + "\n");

			if (player.getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
				playerTurn = false;
				dealerTurn = false;
				System.out.println("Holy moly me oh my. Both dealer and player have been delt 21 to start! Tie!");
			} else if (player.getHand().isBlackJack()) {
				playerTurn = false;
				dealerTurn = false;
				System.out.println("Congrats! You've been delt a winning hand!");
			} else if (dealer.getHand().isBlackJack()) {
				playerTurn = false;
				dealerTurn = false;
				System.out.println("Aw, the dealer has been delt 21, they win.");
			}

			while (playerTurn) {
				hitOrStayTxt();
				try {
					playerSelection = kb.nextInt();
					kb.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("You must enter either 1 or 2\n");
					kb.nextLine();
					continue;
				}
				if (playerSelection != 1 && playerSelection != 2) {
					System.out.println("You must enter either 1 or 2\n");
					continue;
				}
				if (playerSelection == 2) {
					break;
				}
				player.hit(dealer, player);
				System.out.println("\nYou now have: ");
				player.showHand();
				System.out.print("\nYour hand value is: ");
				System.out.println(player.getHand().getValue() + "\n");
				if ((player.getHand().isBustJack())) {
					System.out.println("Your hand's value is over 21! You've lost.");
					dealerTurn = false;
					break;
				}
				if ((player.getHand().isBlackJack())) {
					System.out.println("Blackjack!!!! You've won!");
					dealerTurn = false;
					break;
				}

			}
			while (dealerTurn) {
				System.out.println("\nDealer's Turn: \n");
				while (dealer.getHand().getValue() < 17) {
					System.out.println("Dealer Hit!\n");
					dealer.hit();
					System.out.println("Dealer is showing: ");
					dealer.cardsOnTable();
					System.out.println("");
				}
				if (dealer.getHand().isBustJack()) {
					System.out.println("\nThe Dealer has gone over 21! Bust! You win!");
					System.out.print("Dealer has: ");
					System.out.println(dealer.getHand().getValue());
					dealer.showHand();
					break;
				} else if ((dealer.getHand().isBlackJack())) {
					System.out.println("\nDealer scored Blackjack!!!! Dealer Wins.");
					System.out.print("Dealer has: ");
					System.out.println(dealer.getHand().getValue());
					dealer.showHand();
					break;
				}
				System.out.println("Dealer Stands!\n");
				dealerTurn = false;
				checkWinner = true;

			}
			if (checkWinner) {
				decideWinner(dealer.getHand(), player.getHand());
			}
			boolean gettingInput = true;
			while (gettingInput) {
				System.out.println("\nPlay again? 1.) Yes! 2.) No!");
				try {
					playerSelection = kb.nextInt();
					kb.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("You must enter either 1 or 2\n");
					kb.nextLine();
					continue;
				}
				if (playerSelection != 1 && playerSelection != 2) {
					System.out.println("You must enter either 1 or 2\n");
					continue;
				}
				if (playerSelection == 2) {
					playAgain = false;
					break;
				} else {
					break;
				}
			}
		}
		kb.close();
	}

	private void welcome() {
		System.out.println("Welcome to Webel's Wondrous casion!");
		System.out.println("We welcome you to sait your wonderlust with this wonderful local.");
		System.out.println(
				"It appears you've bullied, beguiled, or bought your way into the most illustrious Blackjack Game around.");
		System.out.println("Welcome, welcome, welcome! Please, have a seat, order a drink, and enjoy the game. \n"
				+ "Oh, and don't forget, tip your dealer!\n\n");
	}

	private void hitOrStayTxt() {
		System.out.println("\nDealer: Would you like to hit or stay?");
		System.out.println("1.) Hit!");
		System.out.println("2.) Stay.");
	}

	private void dealForTwo(BlackJackDealer dealer, BlackJackPlayer player) {
		dealer.dealCard(dealer);
		dealer.dealCard(player);
		dealer.dealCard(dealer);
		dealer.dealCard(player);
	}

	private void decideWinner(BlackjackHand dealerHand, BlackjackHand playerHand) {
		if (dealerHand.getValue() == playerHand.getValue()) {
			System.out.println("You and the dealer both have a hand value of : " + dealerHand.getValue());
			System.out.println("Tie!");
		} else if (playerHand.getValue() > dealerHand.getValue()) {
			System.out.println("You hand value is greater than the dealers! You've won!");
			System.out.println("Final score:\nYou're score: " + playerHand.getValue());
			System.out.print("You're hand: ");
			playerHand.showHand();
			System.out.println("\nDealer's score: " + dealerHand.getValue());
			System.out.print("Dealer's hand: ");
			playerHand.showHand();
			System.out.println("");
		} else {
			System.out.println("You hand value is less than the dealers! You've Lost.");
			System.out.println("Final score:\nYou're score: " + playerHand.getValue());
			System.out.print("You're hand: ");
			playerHand.showHand();
			System.out.println("\nDealer's score: " + dealerHand.getValue());
			System.out.print("Dealer's hand: ");
			playerHand.showHand();

		}
	}
}
