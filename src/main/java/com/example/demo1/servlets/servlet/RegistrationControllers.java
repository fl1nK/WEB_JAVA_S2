package com.example.demo1.servlets.servlet;

import com.example.demo1.dao.UserDAO;
import com.example.demo1.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.demo1.model.User.ROLE.USER;

@WebServlet(name = "RegistrationControllers", value = "/RegistrationControllers")
public class RegistrationControllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(UserDAO.userIsExist(login)){
            request.setAttribute("error", "This login already exists");
            request.getRequestDispatcher("/registration_menu.jsp").forward(request, response);
        }else{
            UserDAO.save(new User(login, password,0, USER));
            response.sendRedirect("/");
        }

    }
}
