package com.app.coursesapp.dao;

import com.app.coursesapp.entity.User;
import com.app.coursesapp.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {

    private static final  UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
INSERT INTO users(name, birhtday, email, password, role, gender) 
values (?,?,?,?,?,?)
""";

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @SneakyThrows
    @Override
    public User save(User entity) {
        Connection connection = ConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1,entity.getName());
        preparedStatement.setObject(2,entity.getBirthday());
        preparedStatement.setObject(3,entity.getEmail());
        preparedStatement.setObject(4,entity.getPassword());
        preparedStatement.setObject(5,entity.getRole().name());
        preparedStatement.setObject(6,entity.getGender().name());

        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getObject("id",Integer.class));

        return entity;

    }
}
