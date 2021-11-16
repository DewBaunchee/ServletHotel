package by.varyvoda.matvey.servlethotel.service.iface;

import by.varyvoda.matvey.servlethotel.entity.user.User;
import by.varyvoda.matvey.servlethotel.service.authentication.Authentication;
import by.varyvoda.matvey.servlethotel.util.Errors;

public interface IAuthenticationService {

    Authentication login(String username, String password);

    Errors register(User user);
}
