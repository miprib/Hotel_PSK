package mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Room {

    private Long id;
    private String number;
    private String type;
    private Long hotelId;

    private Hotel hotel;
}