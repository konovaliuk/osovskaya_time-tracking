package org.example.kp_1.dao;

import org.example.kp_1.db.ConnectionPool;
import org.example.kp_1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.SQLException;

//Имплементация DAO, здесь мы пишем реализацию методов, которые хотим использовать и которые объявили в UserDao
public class UserDaoImpl implements UserDao{

    //Метод для сохранения юзера в бд
    @Override
    public void saveUser(){
        //Подключение к базе данных
        Connection con = ConnectionPool.getConnection();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {
            //Заполнение запроса данными
            Session session = factory.getCurrentSession();
            User user = new User("Alex", "Alexeev", "alex_alex", "qwerty");
            session.beginTransaction();
            //Команда выполнения запроса
            session.save(user);
            session.getTransaction().commit();
        }
        finally {
            //Закрываем сессию
            factory.close();
        }
    }

    @Override
    public void readUser() throws SQLException {
        //Подключение к базе данных
        Connection con = ConnectionPool.getConnection();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session = factory.getCurrentSession();
            session.beginTransaction();
            //Заполнение запроса данными(прописываем айди юзера, которого хотим вывести в консоль)
            User readUser = session.get(User.class, 3);
            session.getTransaction().commit();

            System.out.println(readUser);
            System.out.println("Данные получены");
        }
        finally {
            //Закрываем сессию
            factory.close();
        }
    }
}
