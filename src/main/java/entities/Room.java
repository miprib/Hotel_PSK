package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
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

    @ManyToMany
    Set<Reservation> reservations = new HashSet<>();
}