package com.example.demo1.servlets.filter;

import com.example.demo1.dao.OrderDAO;
import com.example.demo1.dao.UserDAO;
import com.example.demo1.model.Orders;
import com.example.demo1.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

/**
 * Acidification filter.
 */
public class AuthFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final User.ROLE role = (User.ROLE) session.getAttribute("role");
            String login2 = (String) session.getAttribute("login");
            moveToMenu(req, res, role, login2);

        } else if (UserDAO.userIsExist(login)) {

            User.ROLE role = UserDAO.getRoleByLoginPassword(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role, login);

        }else {

            moveToMenu(req, res, User.ROLE.UNKNOWN, null);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.ROLE role, String login)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)) {

            req.getSession().setAttribute("listForAdmin", OrderDAO.showForAdmin());
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

        } else if (role.equals(User.ROLE.USER)) {

            req.getSession().setAttribute("list", OrderDAO.showForUser(login));
            req.getSession().setAttribute("money", UserDAO.getMoneyUser(login));
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else if (role.equals(User.ROLE.MASTER)) {

            req.getSession().setAttribute("listForMaster", OrderDAO.showForMaster(login));
            req.getRequestDispatcher("/WEB-INF/view/master_menu.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }

    }


    @Override
    public void destroy() {
    }

}