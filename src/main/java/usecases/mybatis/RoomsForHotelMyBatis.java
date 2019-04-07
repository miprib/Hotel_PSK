package usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.HotelMapper;
import mybatis.dao.ReservationMapper;
import mybatis.dao.ReservationRoomMapper;
import mybatis.dao.RoomMapper;
import mybatis.model.Hotel;
import mybatis.model.Reservation;
import mybatis.model.ReservationRoom;
import mybatis.model.Room;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.*;

@Model
@Getter
@Setter
public class RoomsForHotelMyBatis implements Serializable {

    @Inject
    private RoomMapper roomDAO;
    @Inject
    private HotelMapper hotelDAO;
    @Inject
    private ReservationMapper reservationDAO;
    @Inject
    private ReservationRoomMapper reservationRoomDAO;

    private Room room = new Room();
    private Reservation reservation = new Reservation();
    private ReservationRoom reservationRoom = new ReservationRoom();

    private Hotel hotel;

    private List<Room> rooms;
    private Map<Long, Boolean> checkMap = new HashMap<Long, Boolean>();


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long hotelId = Long.parseLong(requestParameters.get("hotelId"));
        this.hotel = hotelDAO.selectByPrimaryKey(hotelId);
    }

    @Transactional
    public String createRoom() {
        room.setHotelId(this.hotel.getId());
        roomDAO.insert(room);

        return "roomsMyBatis?faces-redirect=true&hotelId=" + this.hotel.getId();
    }

    @Transactional
    public String createReservation() {
        List<Long> checkedRooms = getCheckedRooms();

        rooms = roomDAO.selectSpecific(checkedRooms);

        reservationDAO.insert(reservation);

        for(Room r: rooms){
            reservationRoom.setReservationId(reservation.getId());
            reservationRoom.setRoomId(r.getId());

            reservationRoomDAO.insert(reservationRoom);
        }



        return "roomsMyBatis?faces-redirect=true&hotelId=" + this.hotel.getId();
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