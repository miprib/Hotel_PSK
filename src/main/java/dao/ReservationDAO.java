package dao;

import entities.Reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

}
