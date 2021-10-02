package service;

import database.Database;
import entity.Address;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressService {
    private static final Connection connect = Database.getConnection();
    private static final String SELECT_ALL_ADDRESS_QUERY = "SELECT * FROM addresses ";
    private static final String SAVE_ADDRESS_QUERY = "INSERT INTO addresses (city,street,home) VALUES (?,?,?)";
    private static final String UPDATE_ADDRESS_QUERY = "UPDATE addresses SET  city=?, street=?, home=? WHERE id=? ";
    private static final String DELETE_ADDRESS_QUERY = "DELETE FROM addresses WHERE id=?";
    private static final String GET_HOME_QUERY = "SELECT * FROM addresses WHERE home=?";


    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try (Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ADDRESS_QUERY);
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHome(resultSet.getString("home"));
                addresses.add(address);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public void save(Address address) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SAVE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getHome());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Address address) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(UPDATE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getHome());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Address address) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(DELETE_ADDRESS_QUERY)) {
            preparedStatement.setInt(1, address.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Address> getByHome(String value) {
        List<Address> addresses = new ArrayList<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(GET_HOME_QUERY)) {
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHome(resultSet.getString("home"));
                addresses.add(address);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public void createNewAddress() {
        System.out.println("and his address");
        Scanner scanner1 = new Scanner(System.in);
        Address address = new Address(scanner1.nextLine(), scanner1.nextLine(), scanner1.nextLine());
        save(address);
    }
}



