package dao;

import entities.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class ReservationDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    public List<Reservation> getReservationsForHotel(Long hotelId) {
        Query query = entityManager.createNamedQuery("Reservation.findForHotel", Reservation.class);
        query.setParameter("hotelId", hotelId);

        return query.getResultList();
    }

    public Reservation findReservation(Long id) {
        return entityManager.find(Reservation.class, id);
    }
}
