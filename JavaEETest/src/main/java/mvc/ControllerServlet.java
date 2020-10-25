package mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {

    Model model = new Model();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentBean student = model.getStudent();
        req.setAttribute("Student", student);

        List<String> privateList = new ArrayList<>();
        privateList.add("one");
        privateList.add("two");
        req.setAttribute("privateList", privateList);

        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        req.setAttribute("map", map);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/View.jsp");
        requestDispatcher.forward(req, resp);
    }
}
