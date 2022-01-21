package Javapreproject331.dao;

import Javapreproject331.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        User userToBeUpdate = entityManager.find(User.class, id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname(updateUser.getSurname());
        userToBeUpdate.setAge(updateUser.getAge());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
