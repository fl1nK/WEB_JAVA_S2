package com.example.demo1.servlets.servlet;

import com.example.demo1.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BalanceServlet", value = "/BalanceServlet")
public class BalanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int money = Integer.parseInt(request.getParameter("money"));
        String login = (String) request.getSession().getAttribute("login");

        UserDAO.setMoneyUser(login, money);

        request.setAttribute("pay", "Payment confirmed");
        request.getRequestDispatcher("balance.jsp")
                .forward(request, response);
    }
}
