package by.varyvoda.matvey.servlethotel.dao.infrastructure;

import by.varyvoda.matvey.servlethotel.dao.config.JdbcConfiguration;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class ConnectionPool {

    public static final ConnectionPool INSTANCE =
            new ConnectionPool(
                    JdbcConfiguration.URL,
                    JdbcConfiguration.USERNAME,
                    JdbcConfiguration.PASSWORD,
                    JdbcConfiguration.POOL_SIZE
            );

    private final String url;
    private final String username;
    private final String password;
    private final Integer poolSize;

    private final BlockingQueue<Connection> connections = new LinkedBlockingQueue<>();

    private ConnectionPool(String url, String username, String password, Integer poolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        init();
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    void freeConnection(Connection connection) {
        // TODO connection.commit();
        connections.add(connection);
    }

    private void init() {
        try {
            for (int i = 0; i < poolSize; i++) connections.add(makeProxy());
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private Connection makeProxy() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        ClassLoader connectionClassLoader = connection.getClass().getClassLoader();
        Class<?>[] interfaces = connection.getClass().getInterfaces();
        return  (Connection) Proxy.newProxyInstance(connectionClassLoader, interfaces, new ProxyConnection(connection, this));
    }
}
