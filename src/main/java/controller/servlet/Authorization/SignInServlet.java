package controller.servlet.Authorization;

import com.google.gson.Gson;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {
    private static String LIST = "/signin.jsp";
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.sendRedirect(LIST);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        User user;
        userService.getUserByLogin(login);

        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (userService.getUserByLogin(login) == null || !userService.getUserByLogin(login).getPass().equals(pass)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (!userService.getUserByLogin(login).getLogin().equals(login)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        response.setContentType("text/html");
        response.sendRedirect("/Read");
    }
}
