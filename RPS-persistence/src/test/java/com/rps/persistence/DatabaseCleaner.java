package com.rps.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCleaner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void deleteAllRows(){
        jdbcTemplate.execute("delete from game_results");
    }
}
