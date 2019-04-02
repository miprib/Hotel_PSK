package dao;

import entities.Hotel;
import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDAO {

    @PersistenceContext(unitName = "hotel-h2")
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> getUsers() {
        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }

}
