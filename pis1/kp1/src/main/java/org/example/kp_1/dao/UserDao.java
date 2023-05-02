package org.example.kp_1.dao;

import java.sql.SQLException;

//Интерфейс, в котором объявляем методы
public interface UserDao {
    public void saveUser() throws SQLException;
    public void readUser() throws SQLException;
}
