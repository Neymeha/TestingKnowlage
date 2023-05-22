package com.neymeha.myadminclientapplication.test.core;

import com.neymeha.myadminclientapplication.entity.Anime_List;
import com.neymeha.myadminclientapplication.entity.Categories;
import com.neymeha.myadminclientapplication.entity.Logging;
import com.neymeha.myadminclientapplication.entity.User_Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestGetUserInfoByNickname {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Logging.class)
                .addAnnotatedClass(User_Info.class)
                .addAnnotatedClass(Anime_List.class)
                .addAnnotatedClass(Categories.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Logging logging = (Logging) session.createQuery("from Logging where user_id=3").getSingleResultOrNull();
            session.getTransaction().commit();

            System.out.println(logging.getUser_info());
        }
        finally {
            factory.close();
        }

    }
}
