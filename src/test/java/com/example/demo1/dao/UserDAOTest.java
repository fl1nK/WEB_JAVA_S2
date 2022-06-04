package com.example.demo1.dao;

import com.example.demo1.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void userIsExist() {
        String login = "@1";
        boolean expResult = false;
        boolean result = UserDAO.userIsExist(login);
        assertEquals(expResult,result);
    }

    @Test
    void getRoleByLoginPassword() {
        String login = "@1";
        String pass = "231";
        User.ROLE expResult = User.ROLE.UNKNOWN;
        User.ROLE result = UserDAO.getRoleByLoginPassword(login, pass);
        assertEquals(expResult,result);
    }

    @Test
    void getMoneyUser() {
        String login = "master1";
        int expResult = 0;
        int result = UserDAO.getMoneyUser(login);
        assertEquals(expResult,result);
    }

}