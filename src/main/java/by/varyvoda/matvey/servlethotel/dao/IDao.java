package by.varyvoda.matvey.servlethotel.dao;

import by.varyvoda.matvey.servlethotel.entity.AbstractEntity;

import java.util.List;
import java.util.Map;

public interface IDao<Entity extends AbstractEntity<ID>, ID> {

    void save(Entity entity);

    Entity getById(ID id);

    List<Entity> getByFields(Map<IEntityField<Entity>, Object> values);

    List<Entity> getAll();

    void update(Entity entity);

    void delete(Entity entity);
}
