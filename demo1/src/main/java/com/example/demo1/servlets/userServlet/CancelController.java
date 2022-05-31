package com.example.demo1.servlets.userServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancelController", value = "/CancelController")
public class CancelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cancel"));

        OrderDAO.updateStatusOrder(id, "Canceled");
        response.sendRedirect("/");
    }
}
