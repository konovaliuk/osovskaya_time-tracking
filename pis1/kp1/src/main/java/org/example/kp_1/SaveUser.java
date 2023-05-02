package org.example.kp_1;

import org.example.kp_1.dao.UserDaoImpl;
import org.example.kp_1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

//Метод мейн, который демонстрирует сохранение юзера
public class SaveUser {
    public static void main(String[] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.saveUser();
    }
}