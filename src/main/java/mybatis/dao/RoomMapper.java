package mybatis.dao;

import mybatis.model.Room;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Room record);

    Room selectByPrimaryKey(Long id);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);

    List<Room> selectSpecific(List<Long> id);
}