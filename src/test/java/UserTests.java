import by.varyvoda.matvey.servlethotel.dao.iface.IUserDao;
import by.varyvoda.matvey.servlethotel.entity.security.Role;
import by.varyvoda.matvey.servlethotel.entity.security.User;
import by.varyvoda.matvey.servlethotel.entity.security.UserRole;
import by.varyvoda.matvey.servlethotel.service.authentication.exception.AuthenticationException;
import by.varyvoda.matvey.servlethotel.service.iface.IAuthenticationService;
import by.varyvoda.matvey.servlethotel.util.ServiceLocator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTests {

    private static Role adminRole;
    private final IUserDao userDao = ServiceLocator.get(IUserDao.class);
    private final IAuthenticationService authenticationService = ServiceLocator.get(IAuthenticationService.class);

    @BeforeClass
    public static void init() {
        adminRole = new Role();
        adminRole.setId(1);
        adminRole.setRole(UserRole.ADMIN);
    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername(";asa");
        user.setPassword("s;gdfg");
        user.setRole(adminRole);
        userDao.save(user);
        System.out.println(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void select() {
        User user = userDao.getById(1);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void register() {
        User user = new User();
        user.setUsername("dew");
        user.setPassword("123");
        user.setRole(adminRole);
        authenticationService.register(user);
    }

    @Test
    public void login() throws AuthenticationException {
        System.out.println(authenticationService.login("dew", "123"));
        Assert.assertThrows(AuthenticationException.class, () -> authenticationService.login("dew", "321"));
    }
}
