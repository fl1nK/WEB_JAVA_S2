package com.example.demo1.servlets.masterServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MasterAcceptController", value = "/MasterAcceptController")
public class MasterAcceptController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        OrderDAO.updateStatusOrder(id, "Now under renovation");
        response.sendRedirect("/");
    }
}
