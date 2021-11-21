package by.varyvoda.matvey.servlethotel.util;

import by.varyvoda.matvey.servlethotel.dao.authentication.AuthenticationDao;
import by.varyvoda.matvey.servlethotel.dao.iface.*;
import by.varyvoda.matvey.servlethotel.dao.reservation.ReservationDao;
import by.varyvoda.matvey.servlethotel.dao.role.RoleDao;
import by.varyvoda.matvey.servlethotel.dao.room.RoomDao;
import by.varyvoda.matvey.servlethotel.dao.user.UserDao;
import by.varyvoda.matvey.servlethotel.service.authentication.AuthenticationService;
import by.varyvoda.matvey.servlethotel.service.iface.IAuthenticationService;
import by.varyvoda.matvey.servlethotel.service.iface.IRoomService;
import by.varyvoda.matvey.servlethotel.service.reservation.RoomService;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {

    private static final Map<Class<?>, Object> services = new HashMap<>();

    static {
        register(IRoleDao.class, new RoleDao());
        register(IUserDao.class, new UserDao());
        register(IRoomDao.class, new RoomDao());
        register(IReservationDao.class, new ReservationDao());
        register(IRoomService.class, new RoomService());
        register(IAuthenticationDao.class, new AuthenticationDao());
        register(IAuthenticationService.class, new AuthenticationService());
    }

    public static <R> void register(Class<R> declarationType, R implementation) {
        if (!declarationType.isAssignableFrom(implementation.getClass()))
            throw new IllegalArgumentException("Implementation type: " +
                    implementation.getClass() +
                    " is not assignable to" +
                    declarationType);
        services.put(declarationType, implementation);
    }

    @SuppressWarnings("unchecked")
    public static <R> R get(Class<R> declarationType) {
        R service = (R) services.get(declarationType);
        if (service == null) throw new IllegalArgumentException("No such service: " + declarationType);
        return service;
    }
}
