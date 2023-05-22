package com.neymeha.myadminclientapplication.test.core;

import com.neymeha.myadminclientapplication.entity.Anime_List;
import com.neymeha.myadminclientapplication.entity.Categories;
import com.neymeha.myadminclientapplication.entity.Logging;
import com.neymeha.myadminclientapplication.entity.User_Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class TestSaveLogging {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Logging.class)
                .addAnnotatedClass(User_Info.class)
                .addAnnotatedClass(Anime_List.class)
                .addAnnotatedClass(Categories.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            Logging logging1 = new Logging("herman", "qwerty", "neymeha@mail.ru");
            User_Info user_info = new User_Info("Onigiri","",new Date(2000,01,01));

            logging1.setUser_info(user_info);

            session.beginTransaction();
            session.save(logging1);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
            session.close();
        }

    }
}
