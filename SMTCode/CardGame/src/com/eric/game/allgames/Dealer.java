 /****************************************************************************
 * <b>Title</b>: Dealer.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Dealer for the Game
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.allgames;

import org.apache.log4j.Logger;

import com.eric.game.interfaces.Deck;
import com.eric.game.valueobjects.Person;

/**
 * @author gunboat
 *
 */
public class Dealer extends Player{
	Deck deck;
	Deck discard;
	private static Logger log = Logger.getLogger(Table.class);
	
	
	public Dealer(Deck deck, Deck discard, Person person, String alias){
		super(person, alias);
		this.deck = deck;
		this.discard = discard;
		
	}
	
	public void initialDeal(Player player, int numCards){
		for(int i = 0; i < numCards; i++){
			dealCard(player);
		}
	}
	
	/**
	 * shuffles the deck
	 */
	public void shuffleDeck(){
		deck.shuffleDeck();
	}
	
	/**
	 * deals a card to a player
	 * @param player the player receiving the card
	 */
	public void dealCard(Player player){
		player.addCard(deck.dealCard());
		//discard.addCard(deck.dealCard());
	}
	
	/**
	 * deals a card to him/her self
	 * @param dealer the dealer receiving the card
	 */
	public void dealSelfCard(Dealer dealer){
		dealer.addCard(deck.dealCard());
		//discard.addCard(deck.dealCard());
		
	}
	
	public boolean isDealer(){
		return true;
	}
	

}
