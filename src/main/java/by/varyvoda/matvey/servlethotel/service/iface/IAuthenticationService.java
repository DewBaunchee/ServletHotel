package by.varyvoda.matvey.servlethotel.service.iface;

import by.varyvoda.matvey.servlethotel.service.authentication.Authentication;

public interface IAuthenticationService {

    Authentication login(String username, String password);
}
