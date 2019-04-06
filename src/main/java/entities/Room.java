package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
        @NamedQuery(name = "Room.findSpecific", query = "SELECT r FROM Room r WHERE r.id IN (:roomIDs)")
})
@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String type;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany(mappedBy = "rooms")
    List<Reservation> reservations = new ArrayList<>();
}