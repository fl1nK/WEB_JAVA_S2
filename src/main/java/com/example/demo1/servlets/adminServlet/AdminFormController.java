package com.example.demo1.servlets.adminServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminFormController", value = "/AdminFormController")
public class AdminFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        String master = request.getParameter("master");

        OrderDAO.update(id, price, master);

        request.getRequestDispatcher("/AdminMenuServlet").forward(request, response);

    }
}
