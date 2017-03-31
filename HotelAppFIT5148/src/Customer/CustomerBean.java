/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 *
 * @author situsnow
 */
public class CustomerBean {
    private int customer_id;
    private String title;
    private String firstName;
    private String lastName;
    private int citizenID;
    private String DOB;
    
    private String country;
    private String city;
    private String street;
    private int postalCode;
    
    private int tier_id;
    private String membership;
    
    private int membershipCredit;
    private int phoneNumber;
    private String email;

    public int getCustomer_id() {
        return customer_id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCitizenID() {
        return citizenID;
    }

    public String getDOB() {
        return DOB;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getTier_id() {
        return tier_id;
    }

    public String getMembership() {
        return membership;
    }

    public int getMembershipCredit() {
        return membershipCredit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setTier_id(int tier_id) {
        this.tier_id = tier_id;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setMembershipCredit(int membershipCredit) {
        this.membershipCredit = membershipCredit;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
