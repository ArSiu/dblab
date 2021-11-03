package com.arsiu.model.DAO.interfaces;

import com.arsiu.model.DAO.QueryGenerator;
import com.arsiu.model.manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GeneralDao<T, ID> {
    QueryGenerator getQueryGenerator();

    default List<T> findAll() throws SQLException {

        List<T> entityList = new ArrayList<>();

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryGenerator().generateFindAll());
            for (Object entity : query.list()) {
                entityList.add((T) entity);
            }
            return entityList;
        }
    }

    default T findById(ID id) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryGenerator().generateFindOne());
            query.setParameter("id", id);
            return (T) query.uniqueResult();
        }
    }

    default int create(T entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            int id = (int) session.save(entity);
            session.close();
            return id;
        }
    }

    default void update(T entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            session.close();
        }
    }

    default int delete(ID id) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery(getQueryGenerator().generateDelete());
            query.setParameter("id", id);
            Integer res = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return res;
        }
    }

}