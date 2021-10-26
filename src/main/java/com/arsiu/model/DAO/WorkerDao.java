package com.arsiu.model.DAO;

import com.arsiu.model.models.Worker;
import com.arsiu.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDao implements com.arsiu.model.DAO.interfaces.WorkerDao {
    @Override
    public String getAll() {
        return "SELECT * FROM worker";
    }

    @Override
    public String getById() {
        return "SELECT * FROM worker WHERE worker.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT worker(post_office_id,first_name,last_name,patronymic,position,salary,passport_number,hirring_date,working_hours) VALUES (?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE worker SET post_office_id=?, first_name=?, last_name=?, patronymic=?, position=?,salary=?,passport_number=?,hirring_date=?,working_hours=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM worker WHERE id=?";
    }

    @Override
    public Worker recordEntity(ResultSet resultSet) throws SQLException {
        return (Worker) new Transformer<>(Worker.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Worker worker) throws SQLException {
        preparedStatement.setInt(1, worker.getPostOfficeId());
        preparedStatement.setString(2, worker.getFirstName());
        preparedStatement.setString(3, worker.getLastName());
        preparedStatement.setString(4, worker.getPatronymic());
        preparedStatement.setString(5, worker.getPosition());
        preparedStatement.setFloat(6, worker.getSalary());
        preparedStatement.setInt(7, worker.getPassportNumber());
        preparedStatement.setString(8, worker.getHirringDate());
        preparedStatement.setInt(9, worker.getWorkingHours());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Worker worker) throws SQLException {
        preparedStatement.setInt(10, worker.getId());
        return preparedStatement;
    }
}
