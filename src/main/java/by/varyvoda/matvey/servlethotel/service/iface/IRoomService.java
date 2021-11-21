package by.varyvoda.matvey.servlethotel.service.iface;

import by.varyvoda.matvey.servlethotel.entity.hotel.Room;

import java.util.List;

public interface IRoomService {

    List<Room> getAll();

    void rent(String username, Integer roomId);

    void unrent(String username, Integer roomId);
}
