package com.example.demo1.servlets.userServlet;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.model.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "OrdersController", value = "/OrdersController")
public class OrdersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String device = request.getParameter("device");
        String login = (String) request.getSession().getAttribute("login");

        Date datetime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(datetime);

        OrderDAO.save(new Orders(login,device,date,0,"","Awaiting processing"));
        // response.sendRedirect("/");
        request.getRequestDispatcher("/UserMenuServlet").forward(request, response);

    }
}
