package dao;

import entities.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class RoomDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addRoom(Room room) {
        entityManager.persist(room);
    }

    public List<Room> getRooms() {
        return entityManager.createNamedQuery("Room.findAll", Room.class).getResultList();
    }

    public List<Room> getSpecificRooms(List<Long> ids) {
        Query query = entityManager.createNamedQuery("Room.findSpecific", Room.class);
        query.setParameter("roomIDs", ids);

        return query.getResultList();
    }

    public Room findRoom(Long id) {
        return entityManager.find(Room.class, id);
    }

}
