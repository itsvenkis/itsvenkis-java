package com.itsvenkis.blogspot.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public class BaseDao {

    private final JdbcTemplate jdbcTemplate;

    protected JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    protected BaseDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
