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
  //  private static String LIST = "/listUser.jsp";
    private static String EDIT = "/Update.jsp";

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        User user;
        user = userService.getUserById(id);
        request.setAttribute("qwert", user);

        RequestDispatcher view = request.getRequestDispatcher(EDIT);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPass(request.getParameter("pass"));
        user.setLogin(request.getParameter("login"));
        String id = request.getParameter("id");

        user.setId(Integer.parseInt(id));
        userService.updateUser(user);

        response.sendRedirect("/index.jsp");
        //RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("qwert", userService.getAll());
        //view.forward(request, response);


    }
}
