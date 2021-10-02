package service;

import database.Database;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private static final Connection connect = Database.getConnection();
    private static final String SELECT_ALL_USER_QUERY = "SELECT * FROM users ";
    private static final String SAVE_USER_QUERY = "INSERT INTO users (firstName,secondName,phone) VALUES (?,?,?)";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET  firstName=?, secondName=?, phone=? WHERE id=? ";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?";
    private static final String GET_BY_PHONE_QUERY = "SELECT * FROM users WHERE phone=?";

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER_QUERY);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setPhone(resultSet.getString("phone"));
                users.add(user);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(User user) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SAVE_USER_QUERY)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(UPDATE_USER_QUERY)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(User user) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(DELETE_USER_QUERY)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getByPhone(String value) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(GET_BY_PHONE_QUERY)) {
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setPhone(resultSet.getString("phone"));
                users.add(user);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new user(first name, second name, phone): ");
        User user = new User(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        save(user);
    }
}
