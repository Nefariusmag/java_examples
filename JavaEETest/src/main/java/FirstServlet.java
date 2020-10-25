import cart.Cart;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/run")
public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        get session
        HttpSession session = request.getSession();

//      get attribute from session
        Integer count = (Integer) session.getAttribute("count");

        if(count==null) {
//          set attribute to session
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

        String username = request.getParameter("name");

//        write text to page
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hihao, " + username + " </h1>");
        pw.println("<h2> Your count is: " + count + "</h2>");
        pw.println("</html>");

//        redirect the response
//        response.sendRedirect("https://google.com");
//        response.sendRedirect("/FirstJsp.jsp");

//        create element of class and get value from session
        Cart cart = (Cart) session.getAttribute("cart");

        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (cart == null) {
            cart = new Cart();

//        save element of class new parameter

            cart.setName(name);
            cart.setQuantity(quantity);

            session.setAttribute("cart", cart);


//            forward to other page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/FirstJsp.jsp");
            dispatcher.forward(request, response);
        }


    }
}
