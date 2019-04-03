package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Hotel.findAll", query = "SELECT u FROM Hotel u")
        })
@Entity
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();
}