package dao;

import entities.Hotel;
import entities.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoomDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addRoom(Room room) {
        entityManager.persist(room);
    }

}
