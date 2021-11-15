package by.varyvoda.matvey.servlethotel.entity.user;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends IntegerId {

    private UserRole role;
}
