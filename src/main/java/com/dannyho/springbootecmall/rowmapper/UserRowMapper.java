package com.dannyho.springbootecmall.rowmapper;

import com.dannyho.springbootecmall.model.User;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.builder()
                .userId(resultSet.getInt("user_id"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .createdDate(resultSet.getTimestamp("created_date"))
                .lastModifiedDate(resultSet.getTimestamp("last_modified_date"))
                .build();
    }
}
