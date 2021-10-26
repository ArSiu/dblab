package com.arsiu.model.DAO;

import com.arsiu.model.models.Client;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao implements com.arsiu.model.DAO.interfaces.ClientDao {

    @Override
    public String getAll() {
        return "SELECT * FROM client";
    }

    @Override
    public String getById() {
        return "SELECT * FROM client WHERE client.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT client(phone_number_standart,phone_number_formal) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE client SET phone_number_standart=?, phone_number_formal=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM client WHERE id=?";
    }

    @Override
    public Client recordEntity(ResultSet resultSet) throws SQLException {
        return (Client) new Transformer<>(Client.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Client client) throws SQLException {
        preparedStatement.setString(1, client.getPhoneNumberStandart());
        preparedStatement.setString(2, client.getPhoneNumberFormal());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Client client) throws SQLException {
        preparedStatement.setInt(3, client.getId());
        return preparedStatement;
    }


}
