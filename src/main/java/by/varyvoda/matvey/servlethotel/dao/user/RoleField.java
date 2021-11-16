package by.varyvoda.matvey.servlethotel.dao.user;

import by.varyvoda.matvey.servlethotel.dao.IEntityField;
import by.varyvoda.matvey.servlethotel.entity.user.Role;
import by.varyvoda.matvey.servlethotel.entity.user.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Getter
public enum RoleField implements IEntityField<Role> {
    ROLE("role", Preparer.STRING_PREPARER);

    private final String field;
    private final Preparer preparer;

    public static Role injectValues(Role role, ResultSet resultSet) throws SQLException {
        role.setRole(UserRole.valueOf(resultSet.getString(ROLE.getField())));
        return role;
    }

    @Override
    public void setValue(PreparedStatement statement, Object value, int index) throws SQLException {
        preparer.prepare(statement, value, index);
    }
}
