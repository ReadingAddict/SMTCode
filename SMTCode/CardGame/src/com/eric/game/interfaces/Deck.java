 /****************************************************************************
 * <b>Title</b>: Deck.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Contains lots of cards can be of any type
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.interfaces;

import com.eric.game.valueobjects.Card;

/**
 * @author gunboat
 *
 */
public interface Deck {

	/**
	 * shuffles the deck into a random order
	 */
	public void shuffleDeck();
	/**
	 * creates a deck of cards
	 */
	public void createDeck();
	
	/**
	 * Deal a Card
	 * @return the card being dealt
	 */
	public Card dealCard();
	
	/**
	 * adds a card to the deck
	 * @param card to be added
	 */
	public void addCard(Card card);
}
