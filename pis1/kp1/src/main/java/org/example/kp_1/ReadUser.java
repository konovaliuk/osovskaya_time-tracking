package org.example.kp_1;

import org.example.kp_1.dao.UserDaoImpl;
import org.example.kp_1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

//Метод мейн, который демонстрирует вывода юзера в консоль
public class ReadUser {
    public static void main(String[] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.readUser();
    }
}
