package com.lxs.mj;


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
    private char[] password;

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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}