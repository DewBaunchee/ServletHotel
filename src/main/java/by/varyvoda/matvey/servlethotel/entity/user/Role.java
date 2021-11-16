package by.varyvoda.matvey.servlethotel.entity.user;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Role extends IntegerId {

    public Role(Integer id) {
        setId(id);
    }

    private UserRole role;
}
