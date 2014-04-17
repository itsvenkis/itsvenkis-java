package com.itsvenkis.blogspot.dao.impl;

import com.itsvenkis.blogspot.constants.SQLConstants;
import com.itsvenkis.blogspot.dao.IUserDao;
import com.itsvenkis.blogspot.jacoco.domain.IUser;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public class UserDao extends BaseDao implements IUserDao {

    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void saveUsers(final List<IUser> users) {
        getJdbcTemplate().batchUpdate(SQLConstants.SAVE_USERS.getValueAsString(), new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                IUser user = users.get(i);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setBoolean(3, user.isAcceptTerms());
                ps.setString(4, user.getFirstName());
                ps.setString(5, user.getLastName());
                ps.setString(6, user.getMiddleName());
                if(user.getRegisteredOn() == null){
                    user.setRegisteredOn(Calendar.getInstance());
                }
                ps.setTimestamp(7, new Timestamp(user.getRegisteredOn().getTimeInMillis()));
                ps.setInt(8, user.getAge());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

    @Override
    public void saveUser(IUser user) {
        throw new UnsupportedOperationException("Not yet implemented!!!!");
    }
}
