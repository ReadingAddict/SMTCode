 /****************************************************************************
 * <b>Title</b>: Bank.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Bank for players to draw from
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.interfaces;

import com.eric.game.valueobjects.Chip;

/**
 * @author gunboat
 *
 */
public interface Bank {

	/**
	 * Withdraws money from the players bank so that the player can bet money
	 * @param chip type to withdraw from the bank
	 * @param amt of chips to withdraw from bank
	 */
	public void betMoney(int amt, Chip chip);
	/**
	 * adds money to bank if the player wins or wants to put excess money into bank
	 * @param chip type to add to bank
	 * @param amt of chips to add to bank
	 */
	public void addMoney(int amt, Chip chip);
	
	
}
