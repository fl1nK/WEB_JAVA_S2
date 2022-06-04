package com.example.demo1.dao;

import com.example.demo1.model.Orders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    @Test
    void showForUser() {
        String login = "21";
        List<Orders> expResult = OrderDAO.showForUser(login);
        assertNotNull(expResult);
    }

    @Test
    void showForAdmin() {
        List<Orders> expResult = OrderDAO.showForAdmin();
        assertNotNull(expResult);
    }

    @Test
    void showForMaster() {
        String login = "master1";
        List<Orders> expResult = OrderDAO.showForMaster(login);
        assertNotNull(expResult.get(0));
    }

    @Test
    void show() {
        List<Orders> expResult = OrderDAO.show();
        System.out.println(expResult.get(1).getUserLogin());
        assertNotNull(expResult.get(0));
    }

    @Test
    void showByStatus() {
        String status = "vdsaz";
        List<Orders> expResult = OrderDAO.showByStatus(status);
        assertNotNull(expResult);
    }

    @Test
    void showByMaster() {
        String masterLogin = "master";
        List<Orders> expResult = OrderDAO.showByMaster(masterLogin);
        assertNotNull(expResult);
    }

    @Test
    void getPriceForOrder() {
        int id = 1;
        int price = 0;
        int expResult = OrderDAO.getPriceForOrder(id);
        assertEquals(expResult, price);
    }

    @Test
    void sort() {
        String sort = "priceUp";
        List<Orders> expResult = OrderDAO.sort(sort);
        assertNotNull(expResult);
    }

    @Test
    void getComments() {
        String masterLogin = "21";
        List<Orders> expResult = OrderDAO.getComments(masterLogin);
        assertNotNull(expResult);
    }
}