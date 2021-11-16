package by.varyvoda.matvey.servlethotel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IEntityField<E> {

    String getField();

    void setValue(PreparedStatement statement, Object value, int index) throws SQLException;

    interface Preparer {

        Preparer STRING_PREPARER = (statement, value, index) -> statement.setString(index, (String) value);
        Preparer INTEGER_PREPARER = (statement, value, index) -> statement.setInt(index, (Integer) value);
        Preparer BOOLEAN_PREPARER = (statement, value, index) -> statement.setBoolean(index, (Boolean) value);

        void prepare(PreparedStatement statement, Object value, int index) throws SQLException;
    }
}
