package by.varyvoda.matvey.servlethotel.entity.hotel;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import by.varyvoda.matvey.servlethotel.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Reservation extends IntegerId {

    private Room room;

    private User user;
}
