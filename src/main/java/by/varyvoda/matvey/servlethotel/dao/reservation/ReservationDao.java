package by.varyvoda.matvey.servlethotel.dao.reservation;

import by.varyvoda.matvey.servlethotel.dao.AbstractDao;
import by.varyvoda.matvey.servlethotel.dao.iface.IReservationDao;
import by.varyvoda.matvey.servlethotel.entity.hotel.Reservation;

import java.sql.*;

public class ReservationDao extends AbstractDao<Reservation> implements IReservationDao {

    private static final String DELETE_QUERY = "DELETE FROM reservation";
    private static final String SELECT_QUERY = "SELECT * FROM reservation JOIN room ON room.id = room_id JOIN \"user\" ON \"user\".id = user_id";

    @Override
    protected PreparedStatement prepareSaveStatement(Connection connection, Reservation reservation) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO reservation(room_id, user_id) " +
                        "VALUES(?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setInt(1, reservation.getRoom().getId());
        preparedStatement.setInt(2, reservation.getUser().getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement prepareUpdateStatement(Connection connection, Reservation reservation) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE reservation SET " +
                        "room_id = ?, user_id = ? WHERE id = ?"
        );
        preparedStatement.setInt(1, reservation.getRoom().getId());
        preparedStatement.setInt(2, reservation.getUser().getId());
        preparedStatement.setInt(3, reservation.getId());
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
    protected Reservation processResultRow(ResultSet resultSet) throws SQLException {
        return ReservationField.from(resultSet);
    }
}
