package com.arsiu.model.DAO;

import com.arsiu.model.models.PostOffice;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostOfficeDao implements com.arsiu.model.DAO.interfaces.PostOfficeDao {
    @Override
    public String getAll() {
        return "SELECT * FROM post_office";
    }

    @Override
    public String getById() {
        return "SELECT * FROM post_office WHERE post_office.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT post_office(name,city,address) VALUES (?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE post_office SET name=?, city=?, address=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM post_office WHERE id=?";
    }

    @Override
    public PostOffice recordEntity(ResultSet resultSet) throws SQLException {
        return (PostOffice) new Transformer<>(PostOffice.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, PostOffice postOffice) throws SQLException {
        preparedStatement.setString(1, postOffice.getName());
        preparedStatement.setString(2, postOffice.getCity());
        preparedStatement.setString(3, postOffice.getAddress());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, PostOffice postOffice) throws SQLException {
        preparedStatement.setInt(4, postOffice.getId());
        return preparedStatement;
    }
}
