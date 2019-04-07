package dao;

import entities.Hotel;
import entities.Reservation;
import entities.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    public List<Reservation> getReservations() {
        return entityManager.createNamedQuery("Reservation.findAll", Reservation.class).getResultList();
    }

    public List<Reservation> getReservationsForHotel(Long hotelId) {
        Query query = entityManager.createNamedQuery("Reservation.findForHotel", Reservation.class);
        query.setParameter("hotelId", hotelId);

        return query.getResultList();
    }

    public Reservation findReservation(Long id) { return entityManager.find(Reservation.class, id); }
}
