package by.varyvoda.matvey.servlethotel.service.iface;

import by.varyvoda.matvey.servlethotel.entity.user.User;
import by.varyvoda.matvey.servlethotel.service.authentication.Authentication;
import by.varyvoda.matvey.servlethotel.service.authentication.exception.AuthenticationException;
import by.varyvoda.matvey.servlethotel.util.Errors;

import java.security.NoSuchAlgorithmException;

public interface IAuthenticationService {

    Authentication login(String username, String password) throws AuthenticationException, NoSuchAlgorithmException;

    Errors register(User user) throws NoSuchAlgorithmException;
}
