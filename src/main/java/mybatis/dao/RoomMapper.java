package mybatis.dao;

import mybatis.model.Room;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Apr 07 18:46:01 EEST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Apr 07 18:46:01 EEST 2019
     */
    int insert(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Apr 07 18:46:01 EEST 2019
     */
    Room selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Apr 07 18:46:01 EEST 2019
     */
    List<Room> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Apr 07 18:46:01 EEST 2019
     */
    int updateByPrimaryKey(Room record);
}