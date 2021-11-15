package by.varyvoda.matvey.servlethotel.entity.hotel;

import by.varyvoda.matvey.servlethotel.entity.IntegerId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Room extends IntegerId {

    private Integer label;

    private Boolean hasKitchen;

    private Boolean hasBath;
}
