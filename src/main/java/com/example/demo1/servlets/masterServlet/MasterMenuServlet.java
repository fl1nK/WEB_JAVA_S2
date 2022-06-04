package com.example.demo1.servlets.masterServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MasterMenuServlet", value = "/MasterMenuServlet")
public class MasterMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = String.valueOf(request.getSession().getAttribute("login"));
        request.setAttribute("listForMaster", OrderDAO.showForMaster(login));
        request.getRequestDispatcher("/WEB-INF/view/master_menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = String.valueOf(request.getSession().getAttribute("login"));
        request.setAttribute("listForMaster", OrderDAO.showForMaster(login));
        request.getRequestDispatcher("/WEB-INF/view/master_menu.jsp").forward(request, response);
    }
}
