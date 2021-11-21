package by.varyvoda.matvey.servlethotel.service.reservation;

import by.varyvoda.matvey.servlethotel.dao.iface.IReservationDao;
import by.varyvoda.matvey.servlethotel.dao.iface.IRoomDao;
import by.varyvoda.matvey.servlethotel.dao.iface.IUserDao;
import by.varyvoda.matvey.servlethotel.entity.hotel.Reservation;
import by.varyvoda.matvey.servlethotel.entity.hotel.Room;
import by.varyvoda.matvey.servlethotel.entity.security.User;
import by.varyvoda.matvey.servlethotel.service.iface.IRoomService;
import by.varyvoda.matvey.servlethotel.util.ServiceLocator;

import java.util.List;

public class RoomService implements IRoomService {

    private final IReservationDao reservationDao = ServiceLocator.get(IReservationDao.class);
    private final IRoomDao roomDao = ServiceLocator.get(IRoomDao.class);
    private final IUserDao userDao = ServiceLocator.get(IUserDao.class);

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public void rent(String username, Integer roomId) {
        User user = userDao.getByUsername(username);
        Room room = roomDao.getById(roomId);
        if(room == null || room.getReservation() != null) return;

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservationDao.save(reservation);

        room.setReservation(reservation);
        roomDao.update(room);
    }

    @Override
    public void unrent(String username, Integer roomId) {
        Reservation reservation = reservationDao.getByRoomId(roomId);
        if(!reservation.getUser().getUsername().equals(username)) return;

        Room room = roomDao.getById(roomId);
        room.setReservation(null);
        roomDao.update(room);
        reservationDao.delete(reservation);
    }
}
