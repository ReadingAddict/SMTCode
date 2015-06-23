 /****************************************************************************
 * <b>Title</b>: Table.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Where the game is played and rules are implemented and players sit
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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.eric.game.interfaces.Deck;
import com.eric.game.interfaces.Rule;
import com.eric.game.twentyone.TwentyOneRule;
import com.eric.game.valueobjects.Chip;
import com.eric.game.valueobjects.Person;

/**
 * @author gunboat
 *
 */
public class Table {
	Map<Double, Chip> pot = new HashMap<Double, Chip>();
	List<Player> players = new ArrayList<Player>();
	Rule rules;
	Dealer dealer;
	Scanner in = new Scanner(System.in);
	private static Logger log = Logger.getLogger(Table.class);
	Properties properties = null;
	
	public Table(Rule rules){
		log.info("Hello World");
		this.rules = rules;
		dealer = addDealer(rules.pickDeck(), rules.pickDeck());
	}
	
	/**
	 * runs all the methods to produce the result
	 * @param args
	 */
	public static void main(String [] args){
		PropertyConfigurator.configure("./scripts/log4j.properties");
		Rule twentyOne = new TwentyOneRule(3);
		Table table = new Table(twentyOne);
		Scanner in = new Scanner(System.in);
		String numPlayers = "";
		int numPlaying = 0;
		Boolean success = false;
		
		while(!success){
			System.out.println("How many Players are there");
			numPlayers = in.nextLine();
			if(numPlayers.length() > 1)
				System.out.println("Please enter a Number");
			else if((int)numPlayers.indexOf(0) > 47 || (int)numPlayers.indexOf(0) < 57){
				numPlaying = Integer.parseInt(numPlayers);
				success = true;
			}
			else{
				System.out.println("Please enter a valid number");
			}
		
		}
		table.addPlayers(numPlaying);
		for(int i = 0; i<numPlaying; i++){
		table.playRound(table.playerAtPosition(i), table.getDealer());
		}
		
	}
	
	/**
	 * adds a player to the player list
	 * @param num players to add
	 */
	public void addPlayers(int numPlayers){
		for(int i = 1; i <= numPlayers; i++){
			Person person = new Person("", 1, "");
			String alias = "";
			Boolean success = false;
			
			while(!success){
				try{
					System.out.println("What is the Player's name, age, gender, and alias");
					String data = in.nextLine();
					String[] splitData = data.split(", ");
				
					person = new Person(splitData[0], Integer.parseInt(splitData[1]), splitData[2]);
					alias = splitData[3];
					success = true;
				}
				catch(Exception e){
					System.out.println(e);
				}
				
			}
		players.add(new Player(person, alias));	
		}
	}

	
	/**
	 * adds a Dealer to the game
	 * @param deck the original deck the dealer will use
	 * @param discard the discard deck the dealer will create
	 * @return the Dealer being added
	 */
	public Dealer addDealer(Deck deck, Deck discard){
		Person person = new Person("", 1, "");
		String alias = "";
		Boolean success = false;
		while(!success){
			try{
				System.out.println("What is the Dealers name, age, gender, and alias");
				String data = in.nextLine();
				String[] splitData = data.split(", ");
				
				person = new Person(splitData[0], Integer.parseInt(splitData[1]), splitData[2]);
				alias = splitData[3];
				success = true;
			}
			catch(Exception e){
				System.out.println(e);
			}
				
			}
		dealer = new Dealer(deck, discard, person, alias);
		return dealer;
	}
	
	public void buyIn(Player p, String chipChoice, String numChips){
		
	Chip chip1 = new Chip(2.0, "red", 1);
	Chip chip2 = new Chip(5.0, "blue", 1);
	Chip chip3 = new Chip(10.0, "green", 1);
	Chip chip4 = new Chip(15.0, "black", 1);
	
		
		
			switch(chipChoice){
			
			case "1":
				p.bet(Integer.parseInt(numChips), chip1);
				pot.put(chip1.getChipValue(), chip1);
				break;
			case "2":
				p.bet(Integer.parseInt(numChips), chip2);
				pot.put(chip2.getChipValue(), chip2);
				break;
			case "3":
				p.bet(Integer.parseInt(numChips), chip3);
				pot.put(chip3.getChipValue(), chip3);
				break;
			case "4":
				p.bet(Integer.parseInt(numChips), chip4);
				pot.put(chip4.getChipValue(), chip4);
				break;
			default:
				System.out.println("That is not a valid choice, you have now placed a defalut bet of 1 $2 chip");
				p.bet(1, chip1);
				pot.put(chip1.getChipValue(), chip1);
			}
		
	}
	
	/**
	 * Plays a round of 21 between the Dealer and the Players including betting
	 * @param player the player currently playing
	 * @param dealer the dealer
	 */
	public void playRound(Player player, Dealer dealer){
		
		dealer.shuffleDeck();
		dealer.initialDeal(player, rules.getInitialCardsDealt());
		int playerValue = rules.getHandValue(player);
		int dealerValue = rules.getDealerHandValue(dealer);
		
		
		if(dealerValue == 0)
			dealer.initialDeal(dealer, rules.getInitialCardsDealt());
		dealerValue = rules.getDealerHandValue(dealer);
		
		System.out.println("Dealer's initial hand value :" + dealerValue);
		while(rules.dealerDraw(dealer)){
			dealer.dealSelfCard(dealer);
			dealerValue = rules.getDealerHandValue(dealer);
			System.out.println("Dealer :" + dealerValue);
		}
		
		
		
		System.out.println();
		System.out.println("What type of chip would you like to bet: \n1: $2.00 chip\n2: $5.00 chip\n3: $10.00 chip\n4: $15.00 chip");
		String chipChoice = in.nextLine();
		System.out.println("How many chips would you like to bet");
		String numChips = in.nextLine();
		buyIn(player, chipChoice, numChips);
		
		
		System.out.println();
		System.out.println("Player's initial hand value :" + playerValue);
		
		
		while(!(rules.gameOver(player))){
			
				dealer.dealCard(player);
				playerValue = rules.getHandValue(player);
				System.out.println("Player :" + playerValue);
			
		}
		


		String winnerAlias = rules.winner(player, dealer);
		System.out.println("Winner = " + winnerAlias);
		//Gives money to the appropriate player
		if(winnerAlias.equals(player.getAlias())){
			
		switch(chipChoice){
		case "1":
			player.addMoney(Integer.parseInt(numChips)*2, new Chip(2.0, "red", 1));
			break;
		case "2":
			player.addMoney(Integer.parseInt(numChips)*2, new Chip(5.0, "blue", 1));
			break;
		case "3":
			player.addMoney(Integer.parseInt(numChips)*2, new Chip(10.0, "green", 1));
			break;
		case "4":
			player.addMoney(Integer.parseInt(numChips)*2, new Chip(15.0, "black", 1));
			break;
		}
	
		}
		
		else if(winnerAlias.equals(dealer.getAlias())){
			switch(chipChoice){
			case "1":
				dealer.addMoney(Integer.parseInt(numChips), new Chip(2.0, "red", 1));
				break;
			case "2":
				dealer.addMoney(Integer.parseInt(numChips), new Chip(5.0, "blue", 1));
				break;
			case "3":
				dealer.addMoney(Integer.parseInt(numChips), new Chip(10.0, "green", 1));
				break;
			case "4":
				dealer.addMoney(Integer.parseInt(numChips), new Chip(15.0, "black", 1));
				break;
			}
		}
			
		else{
			switch(chipChoice){
			case "1":
				player.addMoney(Integer.parseInt(numChips), new Chip(2.0, "red", 1));
				break;
			case "2":
				player.addMoney(Integer.parseInt(numChips), new Chip(5.0, "blue", 1));
				break;
			case "3":
				player.addMoney(Integer.parseInt(numChips), new Chip(10.0, "green", 1));
				break;
			case "4":
				player.addMoney(Integer.parseInt(numChips), new Chip(15.0, "black", 1));
				break;
			}
		}
	}
	
	/**
	 * @return the Dealer at the table
	 */
	public Dealer getDealer(){
		return dealer;	
	}
	
	/**
	 * A player to play the game
	 * @param position of the player in the list
	 * @return the player
	 */
	public Player playerAtPosition(int position){
		return players.get(position);
	}
	

}
