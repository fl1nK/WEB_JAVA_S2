package com.example.demo1.servlets.userServlet;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AcceptController", value = "/AcceptController")
public class AcceptController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("pay"));
        String login = (String) request.getSession().getAttribute("login");

        int allMoneyUser = UserDAO.getMoneyUser(login);
        int price = OrderDAO.getPriceForOrder(id);

        if(allMoneyUser >= price){
            int money = allMoneyUser - price;
            UserDAO.payOrder(login, money);
            OrderDAO.updateStatusOrder(id, "Awaiting renovation");
            request.getRequestDispatcher("/UserMenuServlet").forward(request, response);

        }else{
            request.setAttribute("error", "Not enough money in the wallet");
            request.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(request, response);
        }

    }
}
