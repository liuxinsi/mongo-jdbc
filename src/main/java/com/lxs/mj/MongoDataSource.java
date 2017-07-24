package com.lxs.mj;

import com.google.common.base.Strings;
import io.mycat.backend.jdbc.mongodb.MongoDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

/**
 * {@link io.mycat.backend.jdbc.mongodb.MongoConnection}的数据源，初始化<b>单个</b>连接。<br/>
 * 无需池化连接，连接池由{@link com.mongodb.MongoClient}负责。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class MongoDataSource extends MongoJDBCConfig implements DataSource {
    private static final Logger LOG = LoggerFactory.getLogger(MongoDataSource.class);
    private static final String URL_TEMPLATE = "mongodb://%1$s/%2$s";
    private static final String URL_TEMPLATE_WITH_CREDENTIAL = "mongodb://%3$s:%4$s@%1$s/%2$s";
    private final Object lock = new Object();

    private Connection connection;

    private void initConnection(String userName, String password) throws SQLException {
        if (getUrl() == null) {
            throw new IllegalStateException("url property is required");
        }

        synchronized (this.lock) {
            if (!Strings.isNullOrEmpty(userName)
                    && !Strings.isNullOrEmpty(password)) {
                if (!userName.equals(getUserName())) {
                    LOG.debug("passed user name different than config，use passed");
                    setUserName(userName);
                }
                if (!password.equals(getPassword())) {
                    LOG.debug("passed password different than config，use passed");
                    setPassword(password);
                }
            }

            String url;
            if (!Strings.isNullOrEmpty(getUserName()) && getPassword() != null) {
                url = String.format(URL_TEMPLATE_WITH_CREDENTIAL, getUrl(),
                        getDbName(), getUserName(),
                        getPassword());
            } else {
                url = String.format(URL_TEMPLATE, getUrl(), getDbName());
            }

            MongoDriver md = new MongoDriver();
            this.connection = md.connect(url, null);
            LOG.info("established connection : " + String.format(URL_TEMPLATE, getUrl(), getDbName()));
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            synchronized (this.lock) {
                if (this.connection == null) {
                    initConnection(null, null);
                }
            }
        }
        if (this.connection.isClosed()) {
            throw new SQLException("connection was closed");
        }
        return this.connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        if (this.connection == null) {
            synchronized (this.lock) {
                if (this.connection == null) {
                    initConnection(username, password);
                }
            }
        }
        if (this.connection.isClosed()) {
            throw new SQLException("connection was closed");
        }
        return this.connection;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException("getLogWriter");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("setLogWriter");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException("setLoginTimeout");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return (T) this;
        }
        throw new SQLException("DataSource of type [" + getClass().getName() +
                "] cannot be unwrapped as [" + iface.getName() + "]");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this);
    }
}
