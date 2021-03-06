package by.varyvoda.matvey.servlethotel.dao.iface;

import by.varyvoda.matvey.servlethotel.dao.IDao;
import by.varyvoda.matvey.servlethotel.entity.security.User;

public interface IUserDao extends IDao<User, Integer> {

    User getByUsername(String username);
}
