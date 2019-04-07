package mybatis.model;

import entities.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hotel {

    private Long id;
    private String name;
    private String streetAddress;

    private List<Room> rooms = new ArrayList<>();
}