package com.kp3.service;

import com.kp3.dao.UserDAO;
import com.kp3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//���������� ����� Service ��� ���������� DAO �������
@Service
public class UserService {

    public UserService(UserDAO<User> dao) {
        this.dao = dao;
    }

    private final UserDAO<User> dao;

    //���������� ���������� ��� ��������������� �������� � �������� ����������
    @Transactional
    public void saveUser(User user) {
        try {
            dao.save(user);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            return dao.loadAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int id) {
        try {
            return dao.load(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void deleteUser(int id) {
        try {
            dao.delete(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateUser(User user) {
        try {
            dao.update(user);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


}
