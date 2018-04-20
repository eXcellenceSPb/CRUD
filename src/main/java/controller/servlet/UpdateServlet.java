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

@WebServlet(urlPatterns = "/Update")
public class UpdateServlet extends HttpServlet {
    private static String EDIT = "/Update.jsp";
    private static String LIST = "/listUser.jsp";

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user;
            user = userService.getUserById(id);
            request.setAttribute("qwert", user);

            RequestDispatcher view = request.getRequestDispatcher(EDIT);
            view.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPass(request.getParameter("pass"));
        user.setLogin(request.getParameter("login"));
        user.setType(request.getParameter("type"));
        String id = request.getParameter("id");

        user.setId(Integer.parseInt(id));
        userService.updateUser(user);

        response.sendRedirect("/index.jsp");
        //request.setAttribute("qwert", userService.getAll());
    }
}
