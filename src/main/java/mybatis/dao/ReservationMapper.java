package mybatis.dao;

import mybatis.model.Reservation;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Reservation record);

    Reservation selectByPrimaryKey(Long id);

    List<Reservation> selectAll();

    int updateByPrimaryKey(Reservation record);

    List<Reservation> getReservationsForHotel(Long hotelId);
}