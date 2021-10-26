package com.arsiu.model.DAO;

import com.arsiu.model.models.Delivery;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryDao implements com.arsiu.model.DAO.interfaces.DeliveryDao {
    @Override
    public String getAll() {
        return "SELECT * FROM delivery";
    }

    @Override
    public String getById() {
        return "SELECT * FROM delivery WHERE delivery.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT delivery(worker_id,price,type,max_weight,min_weight) VALUES (?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE delivery SET worker_id=?, price=?, type=?, max_weight=?, min_weight=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM delivery WHERE id=?";
    }

    @Override
    public Delivery recordEntity(ResultSet resultSet) throws SQLException {
        return (Delivery) new Transformer<>(Delivery.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Delivery delivery) throws SQLException {
        preparedStatement.setInt(1, delivery.getWorkerId());
        preparedStatement.setFloat(2, delivery.getPrice());
        preparedStatement.setString(3, delivery.getType());
        preparedStatement.setFloat(4, delivery.getMaxWeight());
        preparedStatement.setFloat(5, delivery.getMinWeight());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Delivery delivery) throws SQLException {
        preparedStatement.setInt(6, delivery.getId());
        return preparedStatement;
    }
}
