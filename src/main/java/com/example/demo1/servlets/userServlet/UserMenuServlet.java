package com.example.demo1.servlets.userServlet;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserMenuServlet", value = "/UserMenuServlet")
public class UserMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = String.valueOf(request.getSession().getAttribute("login"));
        request.setAttribute("list", OrderDAO.showForUser(login));
        request.setAttribute("money", UserDAO.getMoneyUser(login));
        request.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = String.valueOf(request.getSession().getAttribute("login"));
        request.setAttribute("list", OrderDAO.showForUser(login));
        request.setAttribute("money", UserDAO.getMoneyUser(login));
        request.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(request, response);

    }
}
