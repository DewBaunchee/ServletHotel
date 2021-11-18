package by.varyvoda.matvey.servlethotel.entity;

import lombok.*;

@Getter
@Setter
public abstract class AbstractEntity<ID> {

    private ID id;
}
