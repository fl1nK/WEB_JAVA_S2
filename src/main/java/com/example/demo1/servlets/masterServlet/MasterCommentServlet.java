package com.example.demo1.servlets.masterServlet;

import com.example.demo1.dao.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MasterCommentServlet", value = "/MasterCommentServlet")
public class MasterCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = String.valueOf(request.getSession().getAttribute("login"));

        request.setAttribute("listComments", OrderDAO.getComments(login));
        request.getRequestDispatcher("/WEB-INF/view/master_comments.jsp").forward(request, response);
    }
}
