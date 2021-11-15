package by.varyvoda.matvey.servlethotel.entity.user;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends IntegerId {

    private String username;

    private String password;

    private Role role;
}
