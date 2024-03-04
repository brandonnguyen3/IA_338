/* 
 Author: Brandon Nguyen
 Date: 03/03
 Changes made: Changed ArrayList to LinkedList to meet requirement 1

 Tests currently work for supplies but not for the occupant since we haven't changed that to
 linked list yet. 
 * 
 */

package edu.ucalgary.oop;

import java.util.LinkedList;

public class Location {
    private String name;
    private String address;
    private LinkedList<DisasterVictim> occupants = new LinkedList<>(); // Initialized
    private LinkedList<Supply> supplies = new LinkedList<>(); // Initialized

    // Constructor
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for occupants
    public LinkedList<DisasterVictim> getOccupants() {
        return new LinkedList<>(occupants); // Return a copy to maintain encapsulation
    }

    // Setter for occupants
    public void setOccupants(LinkedList<DisasterVictim> occupants) {
        this.occupants = new LinkedList<>(occupants); // Clear and addAll in one step, maintains encapsulation
    }

    // Getter for supplies
    public LinkedList<Supply> getSupplies() {
        return new LinkedList<>(supplies); // Return a copy to maintain encapsulation
    }

    // Setter for supplies
    public void setSupplies(LinkedList<Supply> supplies) {
        this.supplies = new LinkedList<>(supplies); // Clear and addAll in one step, maintains encapsulation
    }

    // Add an occupant to occupants
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    // Remove an occupant from occupants
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    // Add a supply to supplies
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    // Remove a supply from supplies
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
}
