package com.arsiu.model.DAO;

import com.arsiu.model.models.Parcel;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcelDao implements com.arsiu.model.DAO.interfaces.ParcelDao {
    @Override
    public String getAll() {
        return "SELECT * FROM parcel";
    }

    @Override
    public String getById() {
        return "SELECT * FROM parcel WHERE parcel.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT parcel(price,weight,dateSend,dateRecive,address_sender,address_reciver) VALUES (?,?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE parcel SET price=?, weight=?, dateSend=?, dateRecive=?, address_sender=?, address_reciver=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM parcel WHERE id=?";
    }

    @Override
    public Parcel recordEntity(ResultSet resultSet) throws SQLException {
        return (Parcel) new Transformer<>(Parcel.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Parcel parcel) throws SQLException {
        preparedStatement.setFloat(1, parcel.getPrice());
        preparedStatement.setFloat(2, parcel.getWeight());
        preparedStatement.setString(3, parcel.getDataSend());
        preparedStatement.setString(4, parcel.getDateRecive());
        preparedStatement.setString(5, parcel.getAddressSender());
        preparedStatement.setString(6, parcel.getAddressReciver());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Parcel parcel) throws SQLException {
        preparedStatement.setInt(7, parcel.getId());
        return preparedStatement;
    }
}
