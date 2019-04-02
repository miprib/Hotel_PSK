package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}