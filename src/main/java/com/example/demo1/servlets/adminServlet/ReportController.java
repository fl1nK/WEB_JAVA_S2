package com.example.demo1.servlets.adminServlet;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.model.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ReportController", value = "/ReportController")
public class ReportController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort = request.getParameter("sort");
        String statusList = request.getParameter("statusList");
        String master = request.getParameter("master");

        List<Orders> list;
        if(!(sort == null)){
            list = OrderDAO.sort(sort);
        }else {
            list = OrderDAO.show();
        }

        request.setAttribute("listReport", list);
        request.getRequestDispatcher("/WEB-INF/view/report_menu.jsp").forward(request, response);
    }
}
