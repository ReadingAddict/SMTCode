 /****************************************************************************
 * <b>Title</b>: TwentyOneDeck.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Standard Deck of Cards
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.twentyone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.eric.game.allgames.Table;
import com.eric.game.interfaces.Deck;
import com.eric.game.valueobjects.Card;
import com.eric.game.valueobjects.Suit;
/**
 * @author gunboat
 *
 */
public class TwentyOneDeck implements Deck{
	int numCards = 52;
	String deckType = "Twenty One";
	List<Card> deck;
	private static Logger log = Logger.getLogger(Table.class);
	
	
	public TwentyOneDeck(){
		createDeck();
	}
	
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Deck#createDeck()
	 */
	public void createDeck(){
		deck = new ArrayList<Card>(52);
		Suit clubs = new Suit(0, "Clubs", "Black");
		Suit spades = new Suit(0, "Spades", "Black");
		Suit hearts = new Suit(0, "Hearts", "Red");
		Suit diamonds = new Suit(0, "Diamonds", "Red");
		
		deck.add(new Card(1, clubs, "Ace of Clubs"));
		deck.add(new Card(1, spades, "Ace of Spades"));
		deck.add(new Card(1, hearts, "Ace of Hearts"));
		deck.add(new Card(1, diamonds, "Ace of Diamonds"));
		
		deck.add(new Card(2, clubs, "Two of Clubs"));
		deck.add(new Card(2, spades, "Two of Spades"));
		deck.add(new Card(2, hearts, "Two of Hearts"));
		deck.add(new Card(2, diamonds, "Two of Diamonds"));
		
		deck.add(new Card(3, clubs, "Three of Clubs"));
		deck.add(new Card(3, spades, "Three of Spades"));
		deck.add(new Card(3, hearts, "Three of Hearts"));
		deck.add(new Card(3, diamonds, "Three of diamonds"));
		
		deck.add(new Card(4, clubs, "Four of Clubs"));
		deck.add(new Card(4, spades, "Four of Spades"));
		deck.add(new Card(4, hearts, "Four of Hearts"));
		deck.add(new Card(4, diamonds, "Four of Diamonds"));
		
		deck.add(new Card(5, clubs, "Five of Clubs"));
		deck.add(new Card(5, spades, "Five of Spades"));
		deck.add(new Card(5, hearts, "Five of Hearts"));
		deck.add(new Card(5, diamonds, "Five of Diamonds"));
		
		deck.add(new Card(6, clubs, "Six of Clubs"));
		deck.add(new Card(6, spades, "Six of Spades"));
		deck.add(new Card(6, hearts, "Six of Hearts"));
		deck.add(new Card(6, diamonds, "Six of Diamonds"));
		
		deck.add(new Card(7, clubs, "Seven of Clubs"));
		deck.add(new Card(7, spades, "Seven of Spades"));
		deck.add(new Card(7, hearts, "Seven of Hearts"));
		deck.add(new Card(7, diamonds, "Seven of Diamonds"));
		
		deck.add(new Card(8, clubs, "Eight of Clubs"));
		deck.add(new Card(8, spades, "Eight of Spades"));
		deck.add(new Card(8, hearts, "Eight of Hearts"));
		deck.add(new Card(8, diamonds, "Eight of Diamonds"));
		
		deck.add(new Card(9, clubs, "Nine of Clubs"));
		deck.add(new Card(9, spades, "Nine of Spades"));
		deck.add(new Card(9, hearts, "Nine of Hearts"));
		deck.add(new Card(9, diamonds, "Nine of Diamonds"));
		
		deck.add(new Card(10, clubs, "10 of Clubs"));
		deck.add(new Card(10, spades, "10 of Spades"));
		deck.add(new Card(10, hearts, "10 of Hearts"));
		deck.add(new Card(10, diamonds, "10 of Diamonds"));
		
		deck.add(new Card(10, clubs, "Jack of Clubs"));
		deck.add(new Card(10, spades, "Jack of Spades"));
		deck.add(new Card(10, hearts, "Jack of Hearts"));
		deck.add(new Card(10, diamonds, "Jack of Diamonds"));
		
		deck.add(new Card(10, clubs, "Queen of Clubs"));
		deck.add(new Card(10, spades, "Queen of Spades"));
		deck.add(new Card(10, hearts, "Queen of Hearts"));
		deck.add(new Card(10, diamonds, "Queen of Diamonds"));
		
		deck.add(new Card(10, clubs, "King of Clubs"));
		deck.add(new Card(10, spades, "King of Spades"));
		deck.add(new Card(10, hearts, "King of Hearts"));
		deck.add(new Card(10, diamonds, "King of Diamonds"));
		
		
		
	}
	

	
	/**
	 * creates a new empty deck
	 */
	public void createEmptyDeck(){
		deck = new ArrayList<Card>(52);
	}
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Deck#shuffleDeck()
	 */
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	

	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Deck#dealCard()
	 */
	public Card dealCard(){
		Card stored = deck.get(0);
		deck.remove(0);
		return stored;
	}
	
	

	

	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Deck#addCard(com.eric.game.valueobjects.Card)
	 */
	public void addCard(Card card){
		deck.add(card);
	}

}
