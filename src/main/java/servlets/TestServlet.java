package servlets;

import dbservice.DAO.UserDAO;
import dbservice.userDataSet.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String LIST = "/listUser.jsp";
    private static String EDIT = "/user.jsp";
    private UserDAO dao;

    public TestServlet() {
        super();
        dao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String forward;
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new User();
            user.setId(id);
            dao.deleteUser(user);
            forward = LIST;
            request.setAttribute("qwert", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            User user;
            user = dao.getUserById(id);
            request.setAttribute("qwert", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST;
            request.setAttribute("qwert", dao.getAll());
        } else {
            forward = EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html");
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPass(request.getParameter("pass"));
        user.setLogin(request.getParameter("login"));
        dao.addUser(user);
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addUser(user);
        } else {
            user.setId(Integer.parseInt(id));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("qwert", dao.getAll());
        view.forward(request, response);
    }
}
