package usecases;

import dao.ReservationDAO;
import entities.Reservation;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class Reservations {

    @Inject
    private ReservationDAO reservationDAO;

    @Getter
    private List<Reservation> allReservations;

    @PostConstruct
    public void init() {
        loadReservationsForHotel();
    }

    private void loadReservationsForHotel() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long hotelId = Long.parseLong(requestParameters.get("hotelId"));

        this.allReservations = reservationDAO.getReservationsForHotel(hotelId);
    }

}
