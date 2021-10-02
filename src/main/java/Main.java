import database.Database;
import entity.Address;
import entity.User;
import service.AddressService;
import service.TableService;
import service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        UserService userService = new UserService();
        TableService tableService = new TableService();

        tableService.creature();

        addressService.createNewAddress();
        userService.createNewUser();

        System.out.println(addressService.getAll());
        System.out.println(userService.getAll());

    }
}


