package com.lxs.mj;


import com.google.common.base.Strings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class MongoJDBCConfig {
    // basic config
    /**
     * 服务ip地址:端口，多已经逗号隔开。<br/>
     * 127.0.0.1:27001,127.0.0.1:26001
     */
    private String url;
    /**
     * 库名
     */
    private String dbName;

    // auth config
    /**
     * MONGO-CR|PLAIN|MONGODB-X509
     */
    private String authMechanism;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码可选
     */
    private String password;

    // write concern config
    /**
     *
     */
    private WriteConcern writeConcern;
    private Integer w;
    private Long wtimeoutMS;


    // connection pool config
    /**
     * 最大连接数
     */
    private Integer maxPoolSize;
    /**
     * 当连接不可用时，最大等待的线程数量。<br/>
     * maxWait = waitQueueMultiple * maxPoolSize
     */
    private Integer waitQueueMultiple;
    /**
     * 等待可用连接的超时时间
     */
    private Long waitQueueTimeoutMS;

    // rs config
    /**
     * 复制集名
     */
    private String replicaSetName;
    /**
     * 是否可连接secondaries复制集
     */
    private Boolean slaveOk;
    /**
     * primary、secondary、nearest。etc...
     */
    private ReadPreference readPreference;


    // connection config
    /**
     * 是否启用ssl连接
     */
    private Boolean ssl;
    /**
     * 连接超时时间
     */
    private Long connectTimeoutMS;
    /**
     * 发送或接收数据的超时时间
     */
    private Long socketTimeoutMS;

    public Properties toProperties() {
        Properties pro = new Properties();

        // 授权
        if (!Strings.isNullOrEmpty(getAuthMechanism())) {
            pro.put("authMechanism", getAuthMechanism());
        }

        // write concern
        if (getWriteConcern() != null) {
            switch (getWriteConcern()) {
                case acknowledged:
                    pro.put("safe", true);
                    break;
                case journal:
                    pro.put("journal", true);
                    break;
            }
        }
        if (getW() != null) {
            pro.put("w", getW());
        }
        if (getWtimeoutMS() != null) {
            pro.put("wtimeoutMS", getWtimeoutMS());
        }

        // 连接池
        if (getMaxPoolSize() != null) {
            pro.put("maxPoolSize", getMaxPoolSize());
        }
        if (getWaitQueueMultiple() != null) {
            pro.put("waitQueueMultiple", getWaitQueueMultiple());
        }
        if (getWaitQueueTimeoutMS() != null) {
            pro.put("waitQueueTimeoutMS", getWaitQueueTimeoutMS());
        }

        // 复制集
        if (!Strings.isNullOrEmpty(getReplicaSetName())) {
            pro.put("replicaSet", getReplicaSetName());
        }
        if (getSlaveOk() != null) {
            pro.put("slaveOk", getSlaveOk());
        }
        if (getReadPreference() != null) {
            pro.put("readPreference", getReadPreference().name());
        }

        // 连接
        if (getSsl() != null) {
            pro.put("ssl", getSsl());
        }
        if (getConnectTimeoutMS() != null) {
            pro.put("connectTimeoutMS", getConnectTimeoutMS());
        }
        if (getSocketTimeoutMS() != null) {
            pro.put("socketTimeoutMS", getSocketTimeoutMS());
        }
        return pro;
    }

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

    public String getAuthMechanism() {
        return authMechanism;
    }

    public void setAuthMechanism(String authMechanism) {
        this.authMechanism = authMechanism;
    }

    public WriteConcern getWriteConcern() {
        return writeConcern;
    }

    public void setWriteConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getWaitQueueMultiple() {
        return waitQueueMultiple;
    }

    public void setWaitQueueMultiple(Integer waitQueueMultiple) {
        this.waitQueueMultiple = waitQueueMultiple;
    }

    public Long getWaitQueueTimeoutMS() {
        return waitQueueTimeoutMS;
    }

    public void setWaitQueueTimeoutMS(Long waitQueueTimeoutMS) {
        this.waitQueueTimeoutMS = waitQueueTimeoutMS;
    }

    public String getReplicaSetName() {
        return replicaSetName;
    }

    public void setReplicaSetName(String replicaSetName) {
        this.replicaSetName = replicaSetName;
    }

    public Boolean getSlaveOk() {
        return slaveOk;
    }

    public void setSlaveOk(Boolean slaveOk) {
        this.slaveOk = slaveOk;
    }


    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Long getConnectTimeoutMS() {
        return connectTimeoutMS;
    }

    public void setConnectTimeoutMS(Long connectTimeoutMS) {
        this.connectTimeoutMS = connectTimeoutMS;
    }

    public Long getSocketTimeoutMS() {
        return socketTimeoutMS;
    }

    public void setSocketTimeoutMS(Long socketTimeoutMS) {
        this.socketTimeoutMS = socketTimeoutMS;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Long getWtimeoutMS() {
        return wtimeoutMS;
    }

    public void setWtimeoutMS(Long wtimeoutMS) {
        this.wtimeoutMS = wtimeoutMS;
    }

    public ReadPreference getReadPreference() {
        return readPreference;
    }

    public void setReadPreference(ReadPreference readPreference) {
        this.readPreference = readPreference;
    }

    public enum WriteConcern {
        acknowledged, journal
    }

    public enum ReadPreference {
        primary, primaryPreferred, secondary, secondaryPreferred, nearest
    }
}