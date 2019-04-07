package mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Reservation {

    private Long id;
    private String customerName;
    private String fromDate;
    private String toDate;

    private List<Room> rooms = new ArrayList<>();
}