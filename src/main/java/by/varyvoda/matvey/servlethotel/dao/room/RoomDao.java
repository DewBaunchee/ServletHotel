package by.varyvoda.matvey.servlethotel.dao.room;

import by.varyvoda.matvey.servlethotel.dao.AbstractDao;
import by.varyvoda.matvey.servlethotel.dao.iface.IRoomDao;
import by.varyvoda.matvey.servlethotel.entity.hotel.Room;

import java.sql.*;

public class RoomDao extends AbstractDao<Room> implements IRoomDao {

    private static final String DELETE_QUERY = "DELETE FROM room";
    private static final String SELECT_QUERY = "SELECT * FROM room";

    @Override
    protected PreparedStatement prepareSaveStatement(Connection connection, Room room) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO room(label, has_kitchen, has_bath) " +
                        "VALUES(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setInt(1, room.getLabel());
        preparedStatement.setBoolean(2, room.getHasKitchen());
        preparedStatement.setBoolean(3, room.getHasBath());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement prepareUpdateStatement(Connection connection, Room room) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE room SET " +
                        "label = ?, has_kitchen = ?, has_bath = ? WHERE id = ?"
        );
        preparedStatement.setInt(1, room.getLabel());
        preparedStatement.setBoolean(2, room.getHasKitchen());
        preparedStatement.setBoolean(3, room.getHasBath());
        preparedStatement.setInt(4, room.getId());
        return preparedStatement;
    }

    @Override
    protected String prepareDeleteTemplate() {
        return DELETE_QUERY;
    }

    @Override
    protected String prepareSelectTemplate() {
        return SELECT_QUERY;
    }

    @Override
    protected Room processResultRow(ResultSet resultSet) throws SQLException {
        return RoomField.from(resultSet);
    }
}
