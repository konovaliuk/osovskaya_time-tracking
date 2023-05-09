package com.kp3.dao;

import com.kp3.entity.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;


import java.util.List;

//����� ��� ���������� ������� DAO
@Repository
public class UserDAOImpl implements UserDAO<User> {

    //� ���� ������ ����������� ���� �������� � ������� EntityManager
    @PersistenceUnit
    private EntityManagerFactory emf;

    //���������� User
    @Override
    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    //������ User
    @Override
    public User load(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    //�������� User
    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    //���������� User
    @Override
    public void update(User user) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    //�������� ���� User
    @Override
    public List<User> loadAll() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.id = 2").getResultList();
        em.close();
        return users;
    }
}
