package com.lxs.mj;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource.xml")
public class SimpleTestWithSpring {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into user('name','pwd') values('test1','pwd1')";
        int i = jdbcTemplate.update(sql);
        Assert.assertTrue(i == 1);

    }

    @Test
    public void testQuery() {
        jdbcTemplate.query(
                "select * from user",
                resultSet -> {
                    System.out.println(resultSet.getObject(1));
                });
    }
}

