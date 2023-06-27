package com.example.demo5.dao;

import com.example.demo5.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void editUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("FROM User",User.class).getResultList();
    }
}

