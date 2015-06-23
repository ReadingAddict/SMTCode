 /****************************************************************************
 * <b>Title</b>: Card.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Card that will make up Deck and Player hands
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.valueobjects;


/**
 * @author gunboat
 *
 */
/**
 * @author gunboat
 *
 */
public class Card {
	int rank;
	String name;
	Suit suit;
	
	/**
	 * initializes the card
	 * @param rank of the card from class Rank
	 * @param suit of the card from class Suit
	 * @param name of the card in full
	 */
	public Card(int rank, Suit suit, String name){
		this.rank = rank;
		this.suit = suit;
		this.name = name;
	}
	
	/**
	 * @return the rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank to set the rank of the card to
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the name of the card
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set the name of the card to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @param suit to set the suit of the card to
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	
	
	

}
