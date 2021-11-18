package by.varyvoda.matvey.servlethotel.service.authentication;

import by.varyvoda.matvey.servlethotel.config.Configuration;
import by.varyvoda.matvey.servlethotel.dao.iface.IUserDao;
import by.varyvoda.matvey.servlethotel.entity.user.User;
import by.varyvoda.matvey.servlethotel.service.authentication.exception.AuthenticationException;
import by.varyvoda.matvey.servlethotel.service.iface.IAuthenticationService;
import by.varyvoda.matvey.servlethotel.util.Errors;
import by.varyvoda.matvey.servlethotel.util.ServiceLocator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class AuthenticationService implements IAuthenticationService {

    private final IUserDao userDao = ServiceLocator.get(IUserDao.class);

    @Override
    public Authentication login(String username, String password) throws AuthenticationException, NoSuchAlgorithmException {
        User user = userDao.getByUsername(username);
        if (user == null) throw new AuthenticationException("No such user: " + username);
        if (!user.getPassword().equals(encodePassword(password)))
            throw new AuthenticationException("Incorrect password");
        return generateToken();
    }

    @Override
    public Errors register(User user) throws NoSuchAlgorithmException {
        Errors errors = Errors.empty();
        if (userDao.getByUsername(user.getUsername()) != null) errors.push("Such user is already exists.");
        if (user.getRole() == null) errors.push("Role isn't assigned.");
        if (errors.size() > 0) return errors;

        user.setPassword(encodePassword(user.getPassword()));
        userDao.save(user);
        return Errors.empty();
    }

    private Authentication generateToken() {
        return Authentication.builder()
                .token(UUID.randomUUID())
                .expirationDate(new Date(new Date().getTime() + Configuration.TOKEN_MINUTE_LIFETIME * 60 * 1000))
                .build();
    }

    private String encodePassword(String password) throws NoSuchAlgorithmException {
        byte[] bytes = MessageDigest.getInstance("SHA-512").digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
