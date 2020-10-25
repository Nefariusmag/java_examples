import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/names")
public class MultyParametersServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String[] names = request.getParameterValues("name");
//        for (String s : names) {
//            System.out.println(s);
//        }

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String elementNames = parameterNames.nextElement();
            System.out.println(elementNames + " = " + request.getParameter(elementNames));
        }

//        Map<String, String[]> parameterMap = request.getParameterMap();

//        parameterMap.forEach((key, value) -> System.out.println(key + ":" + value));

//        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//        }

        String name = request.getParameter("name");

        response.getWriter().write("<html><head></head><body><form action='names' method='post'> " +
                "Hello: " + name + "</br>" +
                "<input type='text' name='name'/> " +
                "<input type='text' name='password'/> " +
                "<input type='submit' name='submit'/> " +
                "</form></body</html>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
