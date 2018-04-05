package controller.servlet;

import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Read")
public class ReadServlet extends HttpServlet {

    private static String LIST = "/listUser.jsp";
  //  private static String EDIT = "/user.jsp";

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("qwert", userService.getAll());

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        view.forward(request, response);
        //response.sendRedirect(LIST);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //request.getRequestDispatcher(LIST);
        response.sendRedirect(LIST);
    }
}
