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
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class RoomsForHotel implements Serializable {

    @Inject
    private RoomDAO roomDAO;
    @Inject
    private HotelDAO hotelDAO;

    @Getter
    @Setter
    private Room room = new Room();

    @Getter
    @Setter
    private Hotel hotel;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long hotelId = Long.parseLong(requestParameters.get("hotelId"));
        this.hotel = hotelDAO.findHotel(hotelId);
    }

    @Transactional
    public String createRoom() {
        room.setHotel(this.hotel);
        roomDAO.addRoom(room);
        return "/rooms.xhtml?faces-redirect=true&hotelId=" + this.hotel.getId();
    }
}