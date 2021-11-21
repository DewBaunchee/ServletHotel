package by.varyvoda.matvey.servlethotel.dao.iface;

import by.varyvoda.matvey.servlethotel.dao.IDao;
import by.varyvoda.matvey.servlethotel.entity.security.Role;
import by.varyvoda.matvey.servlethotel.entity.security.UserRole;

public interface IRoleDao extends IDao<Role, Integer> {
    Role getByRoleName(UserRole roleName);
}
