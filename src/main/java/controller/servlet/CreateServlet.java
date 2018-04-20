package controller.servlet;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Create")
public class CreateServlet extends HttpServlet {
    private static String INSERT = "/user.jsp";
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.sendRedirect(INSERT);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPass(request.getParameter("pass"));
        user.setLogin(request.getParameter("login"));

        userService.addUser(user);

        response.sendRedirect("/index.jsp");
        //request.setAttribute("qwert", userService.getAll());
    }
}
