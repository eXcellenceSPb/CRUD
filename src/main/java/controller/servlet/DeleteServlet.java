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

@WebServlet(urlPatterns = "/Delete")
public class DeleteServlet extends HttpServlet {

    private static String LIST = "/listUser.jsp";

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        User user;
        user = userService.getUserById(id);
        userService.deleteUser(user);
        request.setAttribute("qwert", userService.getAll());

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        view.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher(LIST);
    }
}
