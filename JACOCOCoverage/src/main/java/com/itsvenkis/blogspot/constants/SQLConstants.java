package com.itsvenkis.blogspot.constants;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
public enum SQLConstants {

    SAVE_USERS("INSERT INTO registered_users (user_name,password,accept_terms,first_name,last_name,middle_name,registered_on,age)" +
            " VALUES (?,?,?,?,?,?,?,?)");

    private Object value;

    SQLConstants(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getValueAsString() {
        if (value instanceof String) {
            return (String) value;
        }
        throw new RuntimeException("Can not cast this value to String");
    }
}
