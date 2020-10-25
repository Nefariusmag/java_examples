import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@WebServlet(value = "/add_book", asyncSupported = true)
public class AsyncServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Enumeration<String> parameterNames = request.getParameterNames();
        List<String> list = Collections.list(parameterNames);

        List<String> attributeList = Arrays.asList("name", "author", "page");

        if (list.containsAll(attributeList)) {

            System.out.println("Start to add new book");

            String newBook_name = request.getParameter("name");
            String newBook_author = request.getParameter("author");
            int newBook_pages = Integer.parseInt(request.getParameter("page"));

            String finalNewBook_name = newBook_name;
            String finalNewBook_author = newBook_author;
            int finalNewBook_pages = newBook_pages;

            AsyncContext asyncContext = request.startAsync();
            asyncContext.start(new Runnable() {
                @Override
                public void run() {

                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/java_ee_db", "postgres", "password");
                        Statement statement = connection.createStatement();

                        String query = "INSERT INTO books (title, author, page) VALUES (\'" + finalNewBook_name + "\', \'"+ finalNewBook_author +"\', " + finalNewBook_pages +")";

                        System.out.println(query);

                        statement.executeUpdate(query);

                        PrintWriter printWriter = null;
                        try {
                            printWriter = response.getWriter();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        printWriter.println("Add new book \'" + finalNewBook_name + "\' of " + finalNewBook_author);

                        statement.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            });
            asyncContext.complete();


        } else {
            System.out.println("New book will be not added");
        }


    }
}
