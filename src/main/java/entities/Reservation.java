package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "RESERVATION_ROOM",
            joinColumns = { @JoinColumn(name = "RESERVATION_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROOM_ID") }
    )
    private List<Room> rooms = new ArrayList<>();
}