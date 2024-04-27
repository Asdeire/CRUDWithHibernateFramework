package com.asdeire.persistence.dao;

import com.asdeire.model.RolePermission;
import com.asdeire.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RolePermissionDao {
    public void addRolePermission(RolePermission rolePermission) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(rolePermission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteRolePermission(RolePermission rolePermission) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(rolePermission);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
