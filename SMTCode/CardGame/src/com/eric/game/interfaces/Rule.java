 /****************************************************************************
 * <b>Title</b>: Rule.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Basic structure for all other card game rules
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.interfaces;

import com.eric.game.allgames.Dealer;
import com.eric.game.allgames.Player;

/**
 * @author gunboat
 *
 */
public interface Rule {
	
	/**
	 * chooses which type of deck to use
	 */
	public Deck pickDeck();
	/**
	 * decides if the game is over
	 * @return if the game is over
	 */
	public boolean gameOver(Player player);
	/**
	 * adds money to the pot(table) as a bet
	 * @param amt to bet
	 */
	public boolean betMinAmt(int amt);
	/**
	 * determines who won the game
	 * @return the alias of the player who won or Dealer if Dealer won
	 */
	public String winner(Player player, Dealer dealer);

	/**
	 * Determines the value of the hand and includes a clause for how much an ace is worth
	 * @return the value of the hand
	 * @Param the player whose hand value is being determined
	 */
	public int getHandValue(Player player);
	

	/**
	 * Determines the value of the hand and includes a clause for how much an ace is worth
	 * @return the value of the hand
	 * @Param the player whose hand value is being determined
	 */
	public int getDealerHandValue(Dealer dealer);
	
	
	/**
	 * allows the dealer to draw
	 * @param the dealer who is going to draw
	 */
	public boolean dealerDraw(Dealer dealer);
	
	/**
	 * @return the number of cards to deal initialy
	 */
	public int getInitialCardsDealt();
}
