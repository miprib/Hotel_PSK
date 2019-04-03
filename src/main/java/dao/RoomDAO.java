package dao;

import entities.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoomDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addRoom(Room room) {
        entityManager.persist(room);
    }

    public List<Room> getRooms() {
        return entityManager.createNamedQuery("Room.findAll", Room.class).getResultList();
    }

    public Room findRoom(Long id) { return entityManager.find(Room.class, id); }

}
