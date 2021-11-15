package by.varyvoda.matvey.servlethotel.dao;

import by.varyvoda.matvey.servlethotel.entity.AbstractEntity;

import java.util.List;
import java.util.Map;

public interface IDao<E extends AbstractEntity<ID>, ID> {

    void save(E entity);

    E getById(ID id);

    List<E> getByFields(Map<IEntityField<E>, String> values);

    List<E> getAll();

    void update(E entity);

    void delete(E entity);
}
