package com.arsiu.model.DAO.interfaces;

import com.arsiu.model.presistent.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface GeneralDao<T, ID> {
    String getAll();
    String getById();
    String createElem();
    String updateElem();
    String removeElem();

    T recordEntity(ResultSet resultSet) throws SQLException;

    PreparedStatement setParameters(PreparedStatement preparedStatement, T model) throws SQLException;

    PreparedStatement setId(PreparedStatement preparedStatement, T model) throws SQLException;

    default List<T> findAll() throws SQLException {
        List<T> entityList = new ArrayList<>();
        try (Statement statement = ConnectionManager.setConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAll());
            while (resultSet.next()) {
                entityList.add(recordEntity(resultSet));
            }
            resultSet.close();
            return entityList;
        }
    }

    default T findById(ID id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionManager.setConnection().prepareStatement(getById())) {
            preparedStatement.setObject(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return recordEntity(resultSet);
                }
            }
        }
        return null;
    }

    default int create(T entity) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(createElem())) {
            PreparedStatement statement = setParameters(preparedStatement, entity);
            return statement.executeUpdate();
        }
    }

    default int update(T entity) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateElem())) {
            PreparedStatement statement = setParameters(preparedStatement, entity);
            statement = setId(statement, entity);
            return statement.executeUpdate();
        }
    }

    default int delete(ID id) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeElem())) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate();
        }
    }


}
