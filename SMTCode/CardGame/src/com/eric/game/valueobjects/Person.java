 /****************************************************************************
 * <b>Title</b>: Person.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Person who will become a player, contains basic info
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
public class Person {
	String name;
	int age;
	String gender;
	
	/**
	 * @param name of the person
	 * @param age of the person
	 * @param gender of the person
	 */
	public Person(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
	/**
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name to give the person
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age of the person
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age to give the person
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender of the person
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender to give the person
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
