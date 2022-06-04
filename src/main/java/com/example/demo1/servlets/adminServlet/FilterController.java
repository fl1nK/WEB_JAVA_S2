package com.example.demo1.servlets.adminServlet;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.model.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FilterController", value = "/FilterController")
public class FilterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusList = request.getParameter("statusList");
        String master = request.getParameter("master");

        List<Orders> list;
        if(!(statusList == null)){
            list = OrderDAO.showByStatus(statusList);
        }else if(!(master == null)){
            list = OrderDAO.showByMaster(master);
        }else{
            list = OrderDAO.showForAdmin();
        }
        request.setAttribute("listForAdmin", list);
        request.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(request, response);
    }
}
