package by.varyvoda.matvey.servlethotel.entity.security;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthenticationEntity extends IntegerId {

    private String value;
}
