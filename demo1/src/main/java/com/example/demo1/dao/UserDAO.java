package com.example.demo1.dao;

import com.example.demo1.model.User;

import java.sql.*;

public class UserDAO {
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

    public static void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?)");

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.setInt(4, user.getMoney());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean userIsExist(final String login) {
        boolean result = false;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM users WHERE logins=?");

            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               result = true;
           }

        } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return result;
    }

    public static User.ROLE getRoleByLoginPassword(final String login, final String password) {
            User.ROLE result = User.ROLE.UNKNOWN ;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM users WHERE logins=? AND passwords=?");

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = User.ROLE.valueOf(resultSet.getString("role"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static int getMoneyUser(String login){
        int result;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT moneys FROM users WHERE logins=? ");

            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("moneys");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void setMoneyUser(String login, int money){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE users SET moneys=? WHERE logins=?");

            preparedStatement.setInt(1, getMoneyUser(login) + money);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void payOrder(String login,int money){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE users SET moneys=? WHERE logins=?");

            preparedStatement.setInt(1,  money);
            preparedStatement.setString(2, login);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
