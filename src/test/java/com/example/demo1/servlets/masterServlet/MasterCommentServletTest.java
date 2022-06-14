package com.example.demo1.servlets.masterServlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MasterCommentServletTest {
    @Test
    void doPost() throws ServletException, IOException {

        String path = "/WEB-INF/view/master_comments.jsp";
        final MasterCommentServlet servlet = new MasterCommentServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("login");
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request).getRequestDispatcher(path);
        verify(request).getSession();
        verify(dispatcher).forward(request, response);

    }
}