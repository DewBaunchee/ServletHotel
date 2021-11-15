package by.varyvoda.matvey.servlethotel.dao.infrastructure;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

@RequiredArgsConstructor
public class ProxyConnection implements InvocationHandler {

    private final Connection connection;
    private final ConnectionPool connectionPool;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("close")) {
            connectionPool.freeConnection(connection);
            return null;
        }
        return method.invoke(connection, args);
    }
}
