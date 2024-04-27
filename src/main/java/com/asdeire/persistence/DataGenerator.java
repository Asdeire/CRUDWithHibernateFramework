package com.asdeire.persistence;

import com.asdeire.model.Permission;
import com.asdeire.model.Role;
import com.asdeire.model.User;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataGenerator {
    private final Session session;
    private final Faker faker;

    public DataGenerator(Session session) {
        this.session = session;
        this.faker = new Faker();
    }

    public void generateData() {
        generateUsers();
        generateRoles();
        generatePermissions();
    }

    private void generateUsers() {
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            session.persist(user);
        }
        transaction.commit();
    }

    private void generateRoles() {
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            Role role = new Role();
            role.setName(faker.team().name());
            session.persist(role);
        }
        transaction.commit();
    }

    private void generatePermissions() {
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            Permission permission = new Permission();
            permission.setName(faker.lorem().word());
            session.persist(permission);
        }
        transaction.commit();
    }
}

