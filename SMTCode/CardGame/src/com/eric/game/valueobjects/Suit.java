 /****************************************************************************
 * <b>Title</b>: Suit.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Suit of a Card
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
public class Suit {
	int value;
	String name;
	String color;
	
	/**
	 * @param value of the suit
	 * @param name of the suit
	 * @param color of the suit
	 */
	public Suit(int value, String name, String color){
		this.value = value;
		this.name = name;
		this.color= color;
	}
	
	
	/**
	 * @return the value of the suit
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value to set the suit to
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the name of the suit
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name to give the suit
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the color of the suit
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color to give the suit
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
