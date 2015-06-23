 /****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Person who  will be playing the game
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.allgames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.eric.game.interfaces.Bank;
import com.eric.game.valueobjects.Card;
import com.eric.game.valueobjects.Chip;
import com.eric.game.valueobjects.Person;

/**
 * @author gunboat
 *
 */
public class Player {
	String alias;
	Person person;
	ChipBank bank;
	List<Card> hand = new ArrayList<Card>(16);
	Scanner in = new Scanner(System.in);
	private static Logger log = Logger.getLogger(Table.class);
	
	
	/**
	 * @param person the person who will be the player
	 * @param alias the alias of the person
	 */
	public Player(Person person, String alias){
		this.alias = alias;
		this.person = person;
		setBank();
	}

	/**
	 * Sets the original bank of each player to a standard amount
	 */
	public void setBank(){
		HashMap<Double, Chip> playerBank = new HashMap<Double, Chip>();
		playerBank.put(2.0, new Chip(2.0, "red", 10));
		playerBank.put(5.0, new Chip(5.0, "blue", 10));
		playerBank.put(10.0, new Chip(10.0, "green", 10));
		playerBank.put(15.0, new Chip(15.0, "black", 10));
		bank = new ChipBank(playerBank);
		
		
	}
	
	/**
	 * Player bets money
	 * @param numChips number of Chips to bet
	 * @param chip the type of chip to bet
	 */
	public void bet(int numChips, Chip chip){
		bank.betMoney(numChips, chip);
	}
	
	/**
	 * adds money to the bank
	 * @param numChips the number of chips to add
	 * @param chip the type of chip to add
	 */
	public void addMoney(int numChips, Chip chip){
		bank.addMoney(numChips, chip);
	}
	
		
	public String drawCard(){
	System.out.println("Do you want to draw a card, yes or no");
	String answer = in.nextLine();
	return answer;
	}
	
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	/**
	 * @return the hand of the player
	 */
	public List<Card> getHand(){
		return hand;
	}
	
	/**
	 * @return the alias of the player
	 */
	public String getAlias() {
		return alias;
	}


	/**
	 * @param alias the alias to give the player
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}


	/**
	 * @return the person who is the player
	 */
	public Person getPerson() {
		return person;
	}


	/**
	 * @param person set the player to be a different person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}


}
