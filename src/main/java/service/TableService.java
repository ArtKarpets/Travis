package service;

import database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableService {
    private static final Connection connect = Database.getConnection();
    private static final String CREATE_TABLE_ADDRESS_QUERY = "CREATE TABLE  addresses (id serial UNIQUE NOT NULL CONSTRAINT addresses_pk PRIMARY KEY, city varchar(15), street varchar (15), home varchar(15))";
    private static final String CREATE_TABLE_USER_QUERY = "CREATE TABLE  users (id serial UNIQUE NOT NULL CONSTRAINT users_pk PRIMARY KEY, firstName varchar(15), secondName varchar (15), phone varchar(15))";

    public void creature() throws SQLException {
        Statement statement = connect.createStatement();
        statement.executeUpdate(CREATE_TABLE_USER_QUERY);
        statement.executeUpdate(CREATE_TABLE_ADDRESS_QUERY);
        statement.close();
        connect.close();
    }
}
