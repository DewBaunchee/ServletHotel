package by.varyvoda.matvey.servlethotel.dao.iface;

import by.varyvoda.matvey.servlethotel.dao.IDao;
import by.varyvoda.matvey.servlethotel.entity.security.AuthenticationEntity;

public interface IAuthenticationDao extends IDao<AuthenticationEntity, Integer> {
    AuthenticationEntity getByValue(String value);
}
