package servlets;

import dbservice.DAO.UserDAO;
import dbservice.userDataSet.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST = "/listUser.jsp";
    private UserDAO dao;

    public TestServlet() {
        super();
        dao = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteUser(id);
            forward = LIST;
            request.setAttribute("qwert", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            User user;
            user = dao.getUserById(id);
            request.setAttribute("qwert", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST;
            request.setAttribute("qwert", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPass(request.getParameter("pass"));
        user.setPass(request.getParameter("login"));

        // String id = request.getParameter("id");
        // if (id == null || id.isEmpty()) {
        dao.addUser(user);
        // } else {
        //     user.setId(Integer.parseInt(id));
        dao.updateUser(user);
        // }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("qwert", dao.getAll());
        view.forward(request, response);
    }
}
