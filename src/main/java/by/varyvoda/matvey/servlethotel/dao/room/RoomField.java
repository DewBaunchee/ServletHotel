package by.varyvoda.matvey.servlethotel.dao.room;

import by.varyvoda.matvey.servlethotel.dao.IEntityField;
import by.varyvoda.matvey.servlethotel.entity.hotel.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Getter
public enum RoomField implements IEntityField<Room> {
    LABEL("label", Preparer.INTEGER_PREPARER),
    HAS_KITCHEN("has_kitchen", Preparer.BOOLEAN_PREPARER),
    HAS_BATH("has_bath", Preparer.BOOLEAN_PREPARER);

    private final String field;
    private final Preparer preparer;

    public static Room from(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        return injectValues(room, resultSet);
    }

    public static Room injectValues(Room room, ResultSet resultSet) throws SQLException {
        room.setLabel(resultSet.getInt(LABEL.getField()));
        room.setHasKitchen(resultSet.getBoolean(HAS_KITCHEN.getField()));
        room.setHasBath(resultSet.getBoolean(HAS_BATH.getField()));
        return room;
    }

    @Override
    public void setValue(PreparedStatement statement, Object value, int index) throws SQLException {
        preparer.prepare(statement, value, index);
    }
}
