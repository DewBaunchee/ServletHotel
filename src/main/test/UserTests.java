import by.varyvoda.matvey.servlethotel.dao.user.UserDao;
import by.varyvoda.matvey.servlethotel.entity.user.Role;
import by.varyvoda.matvey.servlethotel.entity.user.User;
import by.varyvoda.matvey.servlethotel.entity.user.UserRole;
import org.junit.Assert;
import org.junit.Test;

public class UserTests {

    private final UserDao userDao = new UserDao();

    @Test
    public void save() {
        User user = new User();
        user.setUsername(";asa");
        user.setPassword("s;gdfg");
        Role role = new Role();
        role.setId(1);
        role.setRole(UserRole.ADMIN);
        user.setRole(role);
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
}
