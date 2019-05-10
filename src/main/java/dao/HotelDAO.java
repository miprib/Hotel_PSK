package dao;

import entities.Hotel;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HotelDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addHotel(Hotel hotel) {
        entityManager.persist(hotel);
    }

    public List<Hotel> getHotels() {
        return entityManager.createNamedQuery("Hotel.findAll", Hotel.class).getResultList();
    }

    public Hotel findHotel(Long id) {
        return entityManager.find(Hotel.class, id);
    }

    public Hotel updateHotel(Hotel hotel){
        return entityManager.merge(hotel);
    }

}
