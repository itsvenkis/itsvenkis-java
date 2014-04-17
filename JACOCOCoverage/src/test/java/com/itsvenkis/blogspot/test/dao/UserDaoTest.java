package com.itsvenkis.blogspot.test.dao;

import com.itsvenkis.blogspot.dao.IUserDao;
import com.itsvenkis.blogspot.jacoco.domain.IUser;
import com.itsvenkis.blogspot.jacoco.domain.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath*:com/itsvenkis/blogspot/test/resources/spring-*.xml"}
)
public class UserDaoTest {

    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    @Rollback(true)
    public void testSaveUsers(){
       IUser user = new User();
       user.setUserName("ïtsvenkis");
       user.setPassword("itsvenkis");
       user.setAge(28);
       user.setRegisteredOn(Calendar.getInstance());
       user.setAcceptTerms(true);
       user.setFirstName("Venkat");
       user.setLastName("Nanda");
       List<IUser> users = new ArrayList();
       users.add(user);
       getUserDao().saveUsers(users);
    }
}
