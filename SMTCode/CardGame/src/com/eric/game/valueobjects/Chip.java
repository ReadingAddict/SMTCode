 /****************************************************************************
 * <b>Title</b>: Chip.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> form of cash used as Bank for the players
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
public class Chip{
	double chipValue;
	String color;
	int numChips;
	
	/**
	 * @param chipValue the value of the chip in monetary terms
	 * @param color the color of the chip
	 */
	public Chip(double chipValue, String color, int numChips){
		this.chipValue = chipValue;
		this.color = color;
		this.numChips = numChips;
	}

	/**
	 * @return the value of the chip
	 */
	public double getChipValue() {
		return chipValue;
	}

	/**
	 * @param chipValue value to give the chip
	 */
	public void setChipValue(double chipValue) {
		this.chipValue = chipValue;
	}

	/**
	 * @return the color of the chip
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to give the chip
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the number of this type of chip
	 */
	public int getNumChips(){
		return numChips;
	}
	
	/**
	 * @param numChips set the number of chips to this amt
	 */
	public void setNumChips(int numChips){
		this.numChips = numChips;
	}
	
	

}
