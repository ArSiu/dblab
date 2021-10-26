package com.arsiu.model.DAO;

import com.arsiu.model.models.Indent;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndentDao implements com.arsiu.model.DAO.interfaces.IndentDao {
    @Override
    public String getAll() {
        return "SELECT * FROM indent";
    }

    @Override
    public String getById() {
        return "SELECT * FROM indent WHERE indent.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT indent(post_office_from_id,post_office_to_id,sender_id,reciver_id,parcel_id,delivery_id,status) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE indent SET post_office_from_id=?,post_office_to_id=?,sender_id=?,reciver_id=?,parcel_id=?,delivery_id=?,status=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM indent WHERE id=?";
    }

    @Override
    public Indent recordEntity(ResultSet resultSet) throws SQLException {
        return (Indent) new Transformer<>(Indent.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Indent indent) throws SQLException {
        preparedStatement.setInt(1, indent.getPostOfficeFromId());
        preparedStatement.setInt(2, indent.getPostOfficeToId());
        preparedStatement.setInt(3, indent.getSenderId());
        preparedStatement.setInt(4, indent.getReciverId());
        preparedStatement.setInt(5, indent.getParcelId());
        preparedStatement.setInt(6, indent.getDeliveryId());
        preparedStatement.setString(7, indent.getStatus());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Indent indent) throws SQLException {
        preparedStatement.setInt(8, indent.getId());
        return preparedStatement;
    }
}
