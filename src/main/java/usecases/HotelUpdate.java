package usecases;

import dao.HotelDAO;
import entities.Hotel;
import interceptors.LoggedInvocation;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
@Getter
@Setter
public class HotelUpdate implements Serializable {

    @Inject
    private HotelDAO hotelDAO;

    private Hotel hotel;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long hotelId = Long.parseLong(requestParameters.get("hotelId"));
        this.hotel = hotelDAO.findHotel(hotelId);
    }

    @Transactional
    @LoggedInvocation
    public String updateHotel() {
        try {
            System.out.println(this.hotel.toString());
            hotelDAO.updateHotel(this.hotel);
        } catch (OptimisticLockException e) {
            return "updateHotel?faces-redirect=true&hotelId=" + this.hotel.getId() + "&error=optimistic-lock-exception";
        }

        return "rooms?faces-redirect=true&hotelId=" + this.hotel.getId();
    }
}