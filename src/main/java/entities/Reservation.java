package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_DATE")
    private Timestamp fromDate;

    @Column(name = "TO_DATE")
    private Timestamp toDate;

    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "reservations")
    private Set<Room> rooms = new HashSet<>();
}