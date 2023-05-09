package com.kp3;

import com.kp3.config.AppConfig;
import com.kp3.entity.User;
import com.kp3.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        //������� ������� �������
        UserService service = context.getBean(UserService.class);
        //������� �����
        User user = new User("Nikita", "Nikitovich", "nik_222", "nikitovich321");
        //��������� � ����
        service.saveUser(user);
        //��������� ���� ������ � ��
        List<User> list = service.getAllUsers();
        //������� �� ������� �����
        System.out.println(list);

    }
}
