package com.example.demo1.servlets.adminServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminMenuServlet", value = "/AdminMenuServlet")
public class AdminMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listForAdmin", OrderDAO.showForAdmin());
        request.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listForAdmin", OrderDAO.showForAdmin());
        request.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(request, response);

    }
}
