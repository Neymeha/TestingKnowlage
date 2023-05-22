package com.neymeha.myadminclientapplication.test.core;

import com.neymeha.myadminclientapplication.entity.Anime_List;
import com.neymeha.myadminclientapplication.entity.Categories;
import com.neymeha.myadminclientapplication.entity.Logging;
import com.neymeha.myadminclientapplication.entity.User_Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestDeleteLogging {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Logging.class)
                .addAnnotatedClass(User_Info.class)
                .addAnnotatedClass(Anime_List.class)
                .addAnnotatedClass(Categories.class)
                .buildSessionFactory();
        Session session=null;

        try {
            session = factory.openSession();

            session.beginTransaction();
            Logging logging = (Logging) session.createQuery("from Logging where user_id=3").getSingleResultOrNull();
            session.remove(logging); //без этого связанная сущность не хочет удаляться!!!
            session.getTransaction().commit();

        }
        finally {
            factory.close();
            session.close();
        }

    }
}
