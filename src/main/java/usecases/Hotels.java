package usecases;

import dao.HotelDAO;
import entities.Hotel;
import interceptors.MyInterceptor;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
@Getter
@Setter
public class Hotels implements Serializable {

    @Inject
    private HotelDAO hotelDAO;

    private Hotel hotelToCreate = new Hotel();

    private List<Hotel> allHotels;

    @PostConstruct
    public void init() {
        loadAllHotels();
    }

    @Transactional
    @MyInterceptor
    public String createHotel() {
        this.hotelDAO.addHotel(hotelToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllHotels() {
        this.allHotels = hotelDAO.getHotels();
    }
}