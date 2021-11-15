package by.varyvoda.matvey.servlethotel.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntity<ID> {

    private ID id;
}
