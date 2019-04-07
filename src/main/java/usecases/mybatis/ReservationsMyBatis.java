package usecases.mybatis;

import lombok.Getter;
import mybatis.dao.ReservationMapper;
import mybatis.model.Reservation;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class ReservationsMyBatis {

    @Inject
    private ReservationMapper reservationDAO;

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