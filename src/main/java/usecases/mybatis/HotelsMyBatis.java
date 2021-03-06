package usecases.mybatis;

import mybatis.model.Hotel;
import lombok.Getter;
import lombok.Setter;
import mybatis.dao.HotelMapper;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Getter
@Setter
public class HotelsMyBatis {
    @Inject
    private HotelMapper hotelDAO;

    private Hotel hotelToCreate = new Hotel();

    private List<Hotel> allHotels;

    @PostConstruct
    public void init() {
        loadAllHotels();
    }

    @Transactional
    public String createHotel() {
        this.hotelDAO.insert(hotelToCreate);
        return "indexMyBatis?faces-redirect=true";
    }

    private void loadAllHotels() {
        this.allHotels = hotelDAO.selectAll();
    }

}