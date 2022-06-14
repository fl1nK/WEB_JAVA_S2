package com.example.demo1.servlets.masterServlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MasterEndRepairControllerTest {

    @Test
    void doPost() throws ServletException, IOException {
        String path = "/MasterMenuServlet";
        final MasterEndRepairController servlet = new MasterEndRepairController();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter(eq("id"))).thenReturn("1");

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request).getRequestDispatcher(path);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}