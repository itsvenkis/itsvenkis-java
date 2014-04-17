package com.itsvenkis.blogspot.dao;

import com.itsvenkis.blogspot.jacoco.domain.IUser;

import java.util.List;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public interface IUserDao {

    public void saveUsers(List<IUser> users);
    public void saveUser(IUser user);
}
