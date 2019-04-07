package mybatis.dao;

import mybatis.model.Hotel;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Hotel record);

    Hotel selectByPrimaryKey(Long id);

    List<Hotel> selectAll();

    int updateByPrimaryKey(Hotel record);
}