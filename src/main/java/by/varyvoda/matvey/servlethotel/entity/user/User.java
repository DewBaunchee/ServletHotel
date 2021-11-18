package by.varyvoda.matvey.servlethotel.entity.user;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends IntegerId {

    public User(Integer id) {
        setId(id);
    }

    private String username;

    private String password;

    private Role role;
}
