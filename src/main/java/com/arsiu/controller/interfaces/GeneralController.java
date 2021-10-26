package com.arsiu.controller.interfaces;

import com.arsiu.model.DAO.interfaces.GeneralDao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T, ID>{
    GeneralDao<T, ID> generalDoa();

    default List<T> findAll() throws SQLException {
        return generalDoa().findAll();
    }

    default T findById(ID id) throws SQLException {
        return generalDoa().findById(id);
    }

    default int create(T model) throws SQLException {
        return generalDoa().create(model);
    }

    default int update(T model) throws SQLException {
        return generalDoa().update(model);
    }

    default int delete(ID id) throws SQLException {
        return generalDoa().delete(id);
    }
}
