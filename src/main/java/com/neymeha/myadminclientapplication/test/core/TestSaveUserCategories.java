package com.neymeha.myadminclientapplication.test.core;

import com.neymeha.myadminclientapplication.entity.Anime_List;
import com.neymeha.myadminclientapplication.entity.Categories;
import com.neymeha.myadminclientapplication.entity.Logging;
import com.neymeha.myadminclientapplication.entity.User_Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class TestSaveUserCategories {
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

            Logging logging1 = new Logging("stepanov", "qwerty", "stepanov@mail.ru");
            User_Info user_info = new User_Info("Onigiri","",new Date(8000,05,05));

            Categories cat1=new Categories("Drama");
            Categories cat2=new Categories("Action");
            Categories cat3=new Categories("Horror");

            user_info.addUserCategories(cat1);
            user_info.addUserCategories(cat2);
            user_info.addUserCategories(cat3);

            logging1.setUser_info(user_info);

            session.beginTransaction();

//            Logging logging1 = (Logging) session.createQuery("from Logging where user_id=5").getSingleResultOrNull();
//            session.delete(logging1);
            session.persist(logging1);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
            session.close();
        }

    }
}
