 /****************************************************************************
 * <b>Title</b>: TwentyOneRule.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Rules of 21
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.twentyone;

import java.util.List;

import org.apache.log4j.Logger;

import com.eric.game.allgames.Dealer;
import com.eric.game.allgames.Player;
import com.eric.game.allgames.Table;
import com.eric.game.interfaces.Deck;
import com.eric.game.interfaces.Rule;
import com.eric.game.valueobjects.Card;

/**
 * @author gunboat
 *
 */
public class TwentyOneRule implements Rule{
	
	private int initialCardsDealt = 2;
	private int minBet;
	private Deck deckType = new TwentyOneDeck();
	private static Logger log = Logger.getLogger(Table.class);
	
	
	public TwentyOneRule(int minBet){
		this.minBet = minBet;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Rule#getHandValue(com.eric.game.allgames.Player)
	 */
	public int getHandValue(Player player){
		List<Card> hand = player.getHand();
		int value = 0;
		for(Card c: hand){
			if(c.getRank() > 1){
			value += c.getRank();
			}
			if(c.getRank() == 1)
					value += 11;
		}
		
		if(value >21){
			for(Card c: hand){
				if(c.getRank()== 1 && value > 21){
					value -= 10;
				}
			}
		}
		
		return value;
	}
	
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Rule#getDealerHandValue(com.eric.game.allgames.Dealer)
	 */
	public int getDealerHandValue(Dealer dealer){
		List<Card> hand = dealer.getHand();
		int value = 0;
		for(Card c: hand){
			if(c.getRank() > 1){
			value += c.getRank();
			}
			if(c.getRank() == 1)
					value += 11;
		}
		
		if(value >21){
			for(Card c: hand){
				if(c.getRank()== 1 && value > 21){
					value -= 10;
				}
			}
		}
		
		return value;
	}
	
	/**
	 * tells if the player busts
	 * @param player whose hand is being evaluated as a bust 
	 * @return if the player has busted
	 */
	public boolean playerBust(Player player){
	if(getHandValue(player)>21)
		return true;
	else
		return false;
	}
	
	/**
	 * tells if the dealer busts
	 * @param dealer whose hand is being evaluated
	 * @return if the dealer has busted
	 */
	public boolean dealerBust(Dealer dealer){
	if(getDealerHandValue(dealer)>21)
		return true;
	else
		return false;
	}
	

	@Override
	public Deck pickDeck() {
		// TODO Auto-generated method stub
		return deckType;
	}

	@Override
	public boolean gameOver(Player player) {
		// TODO Auto-generated method stub
		if(getHandValue(player)> 21)
			return true;
		
		else if(player.drawCard().equals("no")){
			return true;
		}
				return false;
	}

	@Override
	public boolean betMinAmt(int amt) {
		// TODO Auto-generated method stub
		if(amt < minBet){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Rule#dealerDraw(com.eric.game.allgames.Dealer)
	 */
	public boolean dealerDraw(Dealer dealer){
	if(getDealerHandValue(dealer) >= 17){
		return false;
	}
	return true;
	}
	

	@Override
	public String winner(Player player, Dealer dealer) {
			if(getHandValue(player) > getDealerHandValue(dealer) && !(playerBust(player)))
				return player.getAlias();
			else if(!(dealerBust(dealer)))
				return dealer.getAlias();
			else
				return "No winner both have busted";
	}
	 
	
	/* (non-Javadoc)
	 * @see com.eric.game.interfaces.Rule#getInitialCardsDealt(com.eric.game.allgames.Player)
	 */
	public int getInitialCardsDealt() {
		return initialCardsDealt;
	}


	/**
	 * @param initialCardsDealt the number of cards to deal initialy
	 */
	public void setInitialCardsDealt(int initialCardsDealt) {
		this.initialCardsDealt = initialCardsDealt;
	}


	/**
	 * @return the min amount to bet
	 */
	public int getMinBet() {
		return minBet;
	}


	/**
	 * @param minBet the amt to set minBet to
	 */
	public void setMinBet(int minBet) {
		this.minBet = minBet;
	}

	
	
}
