package com.mahad;

/**
 * This program simulates a lock mechanism with a combination.
 * 
 * The lock can be unlocked with the correct combination, and the combination can be changed
 * if the lock is currently unlocked. The lock also keeps track of unsuccessful attempts and
 * triggers an alarm after three failed attempts.
 * 
 * @version 1.0
 * @since 27/02/2024
 * @author Mahad Khan
 */
public class Lock {

    // Private instance variables
    private String combo;
    private int attempts;
    private boolean unlocked;

    /**
     * Default constructor that initializes the lock with a default combination of "0000".
     */
    public Lock() {
        this.combo = "0000";
        this.attempts = 0;
        this.unlocked = false;
    }

    /**
     * Overloaded constructor that initializes the lock with a specified combination.
     * 
     * @param combo The initial combination for the lock.
     */
    public Lock(String combo) {
        this.combo = combo;
        this.attempts = 0;
        this.unlocked = false;
    }

    /**
     * Checks if the lock is currently unlocked.
     * 
     * @return True if the lock is unlocked, false otherwise.
     */
    public boolean isUnlocked() {
        return unlocked;
    }

    /**
     * Attempts to unlock the lock with the given combination.
     * 
     * @param combo The combination to unlock the lock.
     */
    public void attemptUnlock(String combo) {
        if (this.combo.equals(combo)) {
            unlocked = true;
            attempts = 0;
            System.out.println("Click.");
        } else {
            attempts += 1;
            if (attempts >= 3) {
                System.out.println("Alarm!");
            }
        }
    }

    /**
     * Changes the lock's combination if it is currently unlocked.
     * 
     * @param newCombo The new combination for the lock.
     * @return True if the combination was successfully changed, false otherwise.
     */
    public boolean changeCombo(String newCombo) {
        if (unlocked) {
            combo = newCombo;
            unlocked = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Locks the lock, setting its state to locked.
     */
    public void lock() {
        unlocked = false;
    }

    /**
     * Main method that demonstrates the functionality of the Lock class.
     * 
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Lock l1 = new Lock();
        
        l1.attemptUnlock("4356");
        l1.attemptUnlock("0000");

        if (l1.isUnlocked()) {
            System.out.println("The lock is unlocked.");
        } else {
            System.out.println("The lock is locked.");
        }

        l1.changeCombo("1234");

        l1.attemptUnlock("0000");
        l1.attemptUnlock("3211");

        l1.lock();

        if (l1.isUnlocked()) {
            System.out.println("The lock is unlocked.");
        } else {
            System.out.println("The lock is locked.");
        }
    }
}
