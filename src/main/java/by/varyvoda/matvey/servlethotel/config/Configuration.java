package by.varyvoda.matvey.servlethotel.config;

public final class Configuration {

    public static final String URL = "jdbc:postgresql://localhost:5432/servlet_hotel";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "1";
    public static final Integer POOL_SIZE = 10;

    public static final Integer TOKEN_MINUTE_LIFETIME = 10;
}
