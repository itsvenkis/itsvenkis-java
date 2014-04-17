package com.itsvenkis.blogspot.jacoco.domain.beans;

import com.itsvenkis.blogspot.jacoco.domain.IUser;

import java.util.Calendar;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public class User implements IUser {

    private String userName;
    private String password;
    private boolean acceptTerms;
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private Calendar registeredOn;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Calendar registeredOn) {
        this.registeredOn = registeredOn;
    }

}
