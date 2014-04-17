package com.itsvenkis.blogspot.service;

import com.itsvenkis.blogspot.dao.IUserDao;
import com.itsvenkis.blogspot.jacoco.domain.IUser;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public class UserService {

    private IUserDao userDao;
    private Logger log = Logger.getLogger(UserService.class);

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUsers(List<IUser> users){
        getUserDao().saveUsers(users);
        log.debug("saved users successfully");
    }
}
