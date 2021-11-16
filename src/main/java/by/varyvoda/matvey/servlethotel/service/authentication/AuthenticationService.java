package by.varyvoda.matvey.servlethotel.service.authentication;

import by.varyvoda.matvey.servlethotel.entity.user.User;
import by.varyvoda.matvey.servlethotel.service.iface.IAuthenticationService;
import by.varyvoda.matvey.servlethotel.util.Errors;

public class AuthenticationService implements IAuthenticationService {

    @Override
    public Authentication login(String username, String password) {
        return null;
    }

    @Override
    public Errors register(User user) {
        return null;
    }
}
