/*
 03/04
 Author: Brandon Nguyen
 Changes: Modifyed DisasterVictim to check off requirement 2. 
 (Have not tested)
 */

package edu.ucalgary.oop;

import java.util.LinkedList;

public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private LinkedList<FamilyRelation> familyConnections = new LinkedList<>();
    private LinkedList<MedicalRecord> medicalRecords = new LinkedList<>();
    private LinkedList<Supply> personalBelongings = new LinkedList<>();
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public LinkedList<FamilyRelation> getFamilyConnections() {
        return new LinkedList<>(familyConnections);
    }

    public LinkedList<MedicalRecord> getMedicalRecords() {
        return new LinkedList<>(medicalRecords);
    }

    public LinkedList<Supply> getPersonalBelongings() {
        return new LinkedList<>(personalBelongings);
    }

    public void setFamilyConnections(LinkedList<FamilyRelation> connections) {
        this.familyConnections = new LinkedList<>(connections);
    }

    public void setMedicalRecords(LinkedList<MedicalRecord> records) {
        this.medicalRecords = new LinkedList<>(records);
    }

    public void setPersonalBelongings(LinkedList<Supply> belongings) {
        this.personalBelongings = new LinkedList<>(belongings);
    }

    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        personalBelongings.remove(unwantedSupply);
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        familyConnections.remove(exRelation);
        // Ensure two-sided relationship is removed
        exRelation.getPersonOne().removeFamilyConnection(exRelation);
        exRelation.getPersonTwo().removeFamilyConnection(exRelation);
    }
    
    public void addFamilyConnection(FamilyRelation record) {
        familyConnections.add(record);
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.matches("(?i)^(male|female|other)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
        }
        this.gender = gender.toLowerCase();
    }
}
