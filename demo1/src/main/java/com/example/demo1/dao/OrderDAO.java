package com.example.demo1.dao;

import com.example.demo1.model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void save(Orders orders) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO orders (userlogin, device, dates, price, masterlogin, stat) VALUES(?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, orders.getUserLogin());
            preparedStatement.setString(2, orders.getDevice());
            preparedStatement.setString(3, orders.getDate());
            preparedStatement.setInt(4, orders.getPrice());
            preparedStatement.setString(5, orders.getMasterLogin());
            preparedStatement.setString(6, orders.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static List<Orders> showForUser(String userLogin) {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE userLogin=?");

            preparedStatement.setString(1, userLogin);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));
                orders.setComment(resultSet.getString("comment"));
                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }
    public static List<Orders> showForAdmin() {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM orders WHERE stat NOT iN ('Canceled','Repair completed') ");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }
    public static List<Orders> showForMaster(String master) {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE masterLogin=? AND stat NOT iN ('Repair completed', 'Awaiting processing','Awaiting payment','Canceled')");

            preparedStatement.setString(1, master);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setDevice(resultSet.getString("device"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    public static List<Orders> show() {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    public static List<Orders> showByStatus(String status) {
        List<Orders> allOrders = new ArrayList<>();
        String SQL = null;
        switch (status) {
            case "1":
                SQL = "Awaiting processing";
                break;
            case "2":
                SQL = "Awaiting payment";
                break;
            case "3":
                SQL = "Awaiting renovation";
                break;
            case "4":
                SQL = "Now under renovation";
                break;
            case "5":
                SQL = "Repair completed";
                break;
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE stat=?");

            preparedStatement.setString(1, SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    public static List<Orders> showByMaster(String master) {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE masterLogin=? AND stat NOT iN ('Canceled','Repair completed')");

            preparedStatement.setString(1, master);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    public static void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE ID=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void update(int id, int price, String master) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE orders SET price=?, masterLogin=?, stat=? WHERE id=?");

            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, master);
            preparedStatement.setString(3, "Awaiting payment");
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getPriceForOrder(int id){
            int price = 0;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                price = resultSet.getInt("price");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return price;
    }

    public static String getLoginForOrder(int id){
            String login = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                login = resultSet.getString("userLogin");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return login;
    }

    public static void updateStatusOrder(int id, String status){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE orders SET stat=? WHERE id=?");

            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Orders> sort(String sort) {
        List<Orders> allOrders = new ArrayList<>();
        String SQL = null;
        switch (sort) {
            case "priceUp":
                SQL = "SELECT * FROM orders ORDER BY price";
                break;
            case "priceDown":
                SQL = "SELECT * FROM orders ORDER BY price DESC";
                break;
            case "dateUp":
                SQL = "SELECT * FROM orders ORDER BY dates";
                break;
            case "dateDown":
                SQL = "SELECT * FROM orders ORDER BY dates DESC";
                break;
            case "statusUp":
                SQL = "SELECT * FROM orders ORDER BY stat";
                break;
            case "statusDown":
                SQL = "SELECT * FROM orders ORDER BY stat DESC";
                break;
        }
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders orders = new Orders();

                orders.setID(resultSet.getInt("ID"));
                orders.setUserLogin(resultSet.getString("userLogin"));
                orders.setDevice(resultSet.getString("device"));
                orders.setDate(resultSet.getString("dates"));
                orders.setPrice(resultSet.getInt("price"));
                orders.setMasterLogin(resultSet.getString("masterLogin"));
                orders.setStatus(resultSet.getString("stat"));

                allOrders.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    public static void saveCommentByID(int id, String comment) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE orders SET comment=? WHERE id=?");

            preparedStatement.setString(1, comment);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Orders> getComments(String login) {
        List<Orders> allOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM orders WHERE masterLogin=? ");

            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setComment(resultSet.getString("comment"));

                allOrders.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOrders;

    }
}
