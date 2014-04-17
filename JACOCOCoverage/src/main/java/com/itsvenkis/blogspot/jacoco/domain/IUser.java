package com.itsvenkis.blogspot.jacoco.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itsvenkis.blogspot.jacoco.domain.beans.User;

import java.util.Calendar;
import java.util.Map;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
@JsonDeserialize(as=User.class)
public interface IUser {

    public void setUserName(String userName);
    public String getUserName();

    public void setPassword(String password);
    public String getPassword() ;

    public void setAcceptTerms(boolean acceptTerms) ;
    public boolean isAcceptTerms() ;

    public void setFirstName(String firstName);
    public String getFirstName();

    public void setLastName(String lastName);
    public String getLastName();

    public void setMiddleName(String middleName);
    public String getMiddleName();

    public void setRegisteredOn(Calendar registeredOn);
    public Calendar getRegisteredOn();

    public void setAge(int age);
    public int getAge();

}
