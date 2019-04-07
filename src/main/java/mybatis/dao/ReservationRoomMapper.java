package mybatis.dao;

import mybatis.model.ReservationRoom;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ReservationRoomMapper {

    int insert(ReservationRoom record);

    List<ReservationRoom> selectAll();
}