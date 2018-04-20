package controller.servlet.Authorization;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {
    private static String LIST = "/signin.jsp";
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //doPost(request, response);
        response.sendRedirect(LIST);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        User user;
        user = userService.getUserByLogin(login);
        try {
            if (login == null || pass == null) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            if (user == null || !user.getPass().equals(pass)) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            if (!user.getLogin().equals(login)) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } catch (NullPointerException npe) {
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        HttpSession session = request.getSession();
        switch (userService.getUserRole(login)) {
            case "admin":
                session.getServletContext();
                session.setAttribute("role", "admin");
                session.setAttribute("auth", "1");
                session.setAttribute("login",login);
                response.sendRedirect("/Read");
                return;
            case "user":
                session.getServletContext();
                session.setAttribute("login",login);
                session.setAttribute("role", "user");
                session.setAttribute("auth", "1");
                response.sendRedirect("/test");
                return;
            default:
                session.setAttribute("auth", "0");
                response.sendRedirect("LIST");
        }
    }
}
