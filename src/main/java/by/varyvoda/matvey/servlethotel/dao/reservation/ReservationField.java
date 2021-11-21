package by.varyvoda.matvey.servlethotel.dao.reservation;

import by.varyvoda.matvey.servlethotel.dao.IEntityField;
import by.varyvoda.matvey.servlethotel.dao.room.RoomField;
import by.varyvoda.matvey.servlethotel.dao.user.UserField;
import by.varyvoda.matvey.servlethotel.entity.hotel.Reservation;
import by.varyvoda.matvey.servlethotel.entity.hotel.Room;
import by.varyvoda.matvey.servlethotel.entity.security.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Getter
public enum ReservationField implements IEntityField<Reservation> {
    USER("user_id", Preparer.INTEGER_PREPARER),
    ROOM("room_id", Preparer.INTEGER_PREPARER);

    private final String field;
    private final Preparer preparer;

    public static Reservation from(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("id"));
        return injectValues(reservation, resultSet);
    }

    public static Reservation injectValues(Reservation reservation, ResultSet resultSet) throws SQLException {
        Room room = new Room(resultSet.getInt(ROOM.getField()));
        room.setLabel(resultSet.getInt(RoomField.LABEL.getField()));
        room.setHasKitchen(resultSet.getBoolean(RoomField.HAS_KITCHEN.getField()));
        room.setHasBath(resultSet.getBoolean(RoomField.HAS_BATH.getField()));
        room.setReservation(reservation);

        reservation.setRoom(room);
        reservation.setUser(UserField.injectValues(new User(resultSet.getInt(USER.getField())), resultSet));
        return reservation;
    }

    @Override
    public void setValue(PreparedStatement statement, Object value, int index) throws SQLException {
        preparer.prepare(statement, value, index);
    }
}
