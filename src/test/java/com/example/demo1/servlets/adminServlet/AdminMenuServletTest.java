package com.example.demo1.servlets.adminServlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class AdminMenuServletTest {

    @Test
    void doGet() throws ServletException, IOException {
        String path = "/WEB-INF/view/admin_menu.jsp";
        final  AdminMenuServlet servlet = new AdminMenuServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);


        when(request.getParameter("listForAdmin")).thenReturn("list");
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPost() throws ServletException, IOException {
        String path = "/WEB-INF/view/admin_menu.jsp";
        final  AdminMenuServlet servlet = new AdminMenuServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);


        when(request.getParameter("listForAdmin")).thenReturn("list");
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}