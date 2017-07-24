package com.lxs.mj;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class MongoJDBCConfig {
    /**
     *
     */
    private String url;
    /**
     * db name
     */
    private String dbName;
    /**
     *
     */
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.password = password;
        }
    }
}