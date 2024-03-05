/*
 * 03/04
 * Changes: made changes to adhere to requirement 2
 * Have not tested. Should enforce a bi-directional relationship. 
 */

package edu.ucalgary.oop;

import java.util.Objects;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    // Constructor
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        if (personOne == null || personTwo == null) {
            throw new IllegalArgumentException("Both persons must be specified.");
        }
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
        personOne.addFamilyConnection(this); // Establish the two-sided relationship
        personTwo.addFamilyConnection(this); // Establish the two-sided relationship
    }

    // Getters and setters

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        if (personOne == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        // Remove the relationship from the previous personOne
        this.personOne.removeFamilyConnection(this);
        this.personOne = personOne;
        // Add the relationship to the new personOne
        personOne.addFamilyConnection(this);
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        if (personTwo == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        // Remove the relationship from the previous personTwo
        this.personTwo.removeFamilyConnection(this);
        this.personTwo = personTwo;
        // Add the relationship to the new personTwo
        personTwo.addFamilyConnection(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyRelation that = (FamilyRelation) o;
        return Objects.equals(personOne, that.personOne) &&
                Objects.equals(relationshipTo, that.relationshipTo) &&
                Objects.equals(personTwo, that.personTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personOne, relationshipTo, personTwo);
    }
}
