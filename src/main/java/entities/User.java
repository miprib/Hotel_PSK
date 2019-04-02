package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}