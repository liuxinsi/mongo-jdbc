package com.lxs.mj;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class SimpleTest {
    private Connection connection;

    @Before
    public void init() throws SQLException {
        MongoDataSource mds = new MongoDataSource();
        mds.setUrl("127.0.0.1");
        mds.setDbName("testdb");
        connection = mds.getConnection();
    }

    @Test
    public void testInsert() {
        String sql = "insert into user('name','pwd') values('test1','pwd1')";
        try {
            try (Statement stat = connection.createStatement()) {
                int i = stat.executeUpdate(sql);
                Assert.assertTrue(i == 1);
            }
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testQuery() {
        try {
            try (Statement stat = connection.createStatement();
                 ResultSet rs = stat.executeQuery("select * from user")) {
                while (rs.next()) {
                    System.out.println(rs.getObject(1) + ":" + rs.getObject(2));
                }
            }
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
        }
    }

}
