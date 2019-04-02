package dao;

import entities.Hotel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HotelDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addHotel(Hotel hotel) {
        entityManager.persist(hotel);
    }

    public List<Hotel> getHotels() {
        return entityManager.createNamedQuery("Hotel.findAll", Hotel.class).getResultList();
    }
}
