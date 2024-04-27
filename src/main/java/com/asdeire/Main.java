package com.asdeire;

import com.asdeire.persistence.DataGenerator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream("/hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SessionFactory sessionFactory = new Configuration()
                .addProperties(properties)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            DataGenerator dataGenerator = new DataGenerator(session);
            dataGenerator.generateData();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
