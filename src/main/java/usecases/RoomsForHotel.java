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
import java.util.*;

@Model
public class RoomsForHotel implements Serializable {

    @Inject
    private RoomDAO roomDAO;
    @Inject
    private HotelDAO hotelDAO;
    @Inject
    private ReservationDAO reservationDAO;

    @Getter
    @Setter
    private Room room = new Room();

    @Getter
    @Setter
    private Hotel hotel;

    @Getter
    @Setter
    private Reservation reservation = new Reservation();

    @Getter
    @Setter
    private List<Room> rooms;

    @Getter
    @Setter
    private Map<Long, Boolean> checkMap = new HashMap<Long, Boolean>();


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

    @Transactional
    public String createReservation() {
        List<Long> checkedRooms = getCheckedRooms();

        rooms = roomDAO.getSpecificRooms(checkedRooms);

        reservation.setRooms(rooms);
        reservationDAO.addReservation(reservation);

        return "/rooms.xhtml?faces-redirect=true&hotelId=" + this.hotel.getId();
    }

    private List<Long> getCheckedRooms() {
        List<Long> checkedRooms = new ArrayList<Long>();

        Iterator it = checkMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getValue().equals(true)) {
                checkedRooms.add((Long) pair.getKey());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }

        return checkedRooms;
    }
}