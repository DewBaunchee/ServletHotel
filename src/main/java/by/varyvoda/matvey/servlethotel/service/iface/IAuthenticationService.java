package by.varyvoda.matvey.servlethotel.service.iface;

import by.varyvoda.matvey.servlethotel.entity.security.Role;
import by.varyvoda.matvey.servlethotel.entity.security.User;
import by.varyvoda.matvey.servlethotel.entity.security.UserRole;
import by.varyvoda.matvey.servlethotel.service.authentication.Authentication;
import by.varyvoda.matvey.servlethotel.service.authentication.exception.AuthenticationException;
import by.varyvoda.matvey.servlethotel.util.Errors;

public interface IAuthenticationService {

    Authentication login(String username, String password) throws AuthenticationException;

    Authentication authorize(Authentication authentication);

    Errors register(User user);

    Role getRole(UserRole role);
}
