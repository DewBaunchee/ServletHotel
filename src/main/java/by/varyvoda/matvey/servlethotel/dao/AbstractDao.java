package by.varyvoda.matvey.servlethotel.dao;

import by.varyvoda.matvey.servlethotel.dao.infrastructure.ConnectionPool;
import by.varyvoda.matvey.servlethotel.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractDao<Entity extends AbstractEntity<Integer>> implements IDao<Entity, Integer> {

    public void save(Entity entity) {

    }

    public Entity getById(Integer id) {
        return null;
    }

    public List<Entity> getByFields(Map<IEntityField<Entity>, String> values) {
        return null;
    }

    public List<Entity> getAll() {
        return null;
    }

    public void update(Entity entity) {

    }

    public void delete(Entity entity) {
    }

    protected <R> R inSessionDo(Function<Connection, R> task) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            return task.apply(connection);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void inSessionDo(SessionTask task) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            task.apply(connection);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected interface SessionTask {
        void apply(Connection connection);
    }
}
