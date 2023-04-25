package ru.crudboot.myCrudAppBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.crudboot.myCrudAppBoot.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
