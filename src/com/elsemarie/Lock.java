package com.elsemarie;
/**
* @author Elsemarie Hinahon
* @date 03/21/2024
* Using class to create a lock that can be locked and unlocked with a combination
*/

public class Lock {
	
	/**
	 * Private instance variable for combination value
	 */
	private String combination;
	
	/**
	 * Private instance variable for number of wrong attempts
	 */
	private int wrongAttempts;
	
	/**
	 * Private instance variable for state of lock
	 */
	private String lockState;
	
	
	/**
	 * Default constructors
	 */
	public Lock() {
		this.combination = "0000";
		this.wrongAttempts = 0;
		this.lockState = "locked";
	}
	
	/**
	 * Overloaded constructors
	 * @param combination The combination passed in
	 */
	public Lock(String combination) {
		this.combination = combination;
		this.wrongAttempts = 0;
		this.lockState = "locked";
	}
	/**
	 * Returns true if the lock is unlocked, otherwise false
	 * @return True or false
	 */
	public boolean isUnlocked() {
		if (this.lockState == "locked") {
			return false;
		} else {
			return true;
		}
	}
	
// _________________ OTHER METHODS ______________________
	
	/**
	 * Code for attempting to unlock the lock
	 * @param combination The combination passed in
	 */
	
	public void attemptUnlock(String combination) {
		
		// If combination entered is correct, "click" and unlock the lock
		if (this.combination == combination) {
			this.lockState = "unlocked";
			System.out.println("Click.");
			this.wrongAttempts = 0;
			
		} else {
			// If combination entered is incorrect, "alarm" and increase wrong attempt count by 1
			this.lockState = "locked";
			this.wrongAttempts = this.wrongAttempts + 1;
			if (this.wrongAttempts >= 3) {
				System.out.println("Alarm!");
			}
		}
	}
	
	/**
	 * Code for changing the combination of the lock
	 * @param newCombo The new combination passed in
	 * @return True or False
	 */
	
	// This should only work if the lock is already unlocked!
	public boolean changeCombo(String newCombo) {
		if (this.lockState == "unlocked") {
			this.combination = newCombo;
			this.lockState = "locked";
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Code to lock the lock
	 */
	public void lock() {
		this.lockState = "locked";
	}
}
