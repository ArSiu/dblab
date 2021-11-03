package com.arsiu.controller.interfaces;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T, ID> {
    GeneralDao<T, ID> generalDao();

    default List<T> findAll() throws SQLException {
        return generalDao().findAll();
    }

    default T findById(ID id) throws SQLException {
        return generalDao().findById(id);
    }

    default int create(T model) throws SQLException {
        return generalDao().create(model);
    }

    default void update(T model) throws SQLException {
        generalDao().update(model);
    }

    default int delete(ID id) throws SQLException {
        return generalDao().delete(id);
    }

    String printColumns();
}
