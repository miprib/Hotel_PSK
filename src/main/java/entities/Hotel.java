package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
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

    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    private List<Room> rooms = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @Override
    public String toString(){
        return name + ", " + streetAddress + ", " + version;
    }
}