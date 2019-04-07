package usecases;

import dao.HotelDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import entities.Hotel;
import entities.Reservation;
import entities.Room;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Hotels implements Serializable {

    @Inject
    private HotelDAO hotelDAO;

    @Getter
    @Setter
    private Hotel hotelToCreate = new Hotel();

    @Getter
    private List<Hotel> allHotels;

    @PostConstruct
    public void init() {
        loadAllHotels();
    }

    @Transactional
    public String createHotel() {
        this.hotelDAO.addHotel(hotelToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllHotels() {
        this.allHotels = hotelDAO.getHotels();
    }
}