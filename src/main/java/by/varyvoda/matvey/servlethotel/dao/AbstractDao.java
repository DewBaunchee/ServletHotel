package by.varyvoda.matvey.servlethotel.dao;

import by.varyvoda.matvey.servlethotel.entity.AbstractEntity;

public abstract class AbstractDao<E extends AbstractEntity<Integer>> implements IDao<E, Integer> {
}
