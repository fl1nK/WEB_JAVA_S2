package com.example.demo1.servlets.adminServlet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class AdminFormControllerTest {

    @Test
    void doPost() throws ServletException, IOException {
        String path = "/AdminMenuServlet";
        final  AdminFormController servlet = new AdminFormController();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);


        when(request.getParameter(eq("id"))).thenReturn("10");
        when(request.getParameter(eq("price"))).thenReturn("10");
        when(request.getParameter("master")).thenReturn("master");

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}