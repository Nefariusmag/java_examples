import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/add_book_to_library")
public class AddBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/java_ee_db", "postgres", "password");
            Statement statement = connection.createStatement();

            String newBook_name = "Kurs macroeconomic";
            String newBook_author = "Keins";
            Integer newBook_pages = 655;

            String query = "INSERT INTO books (title, author, page) VALUES (\'" + newBook_name + "\', \'"+ newBook_author +"\', " + newBook_pages +")";

            System.out.println(query);

            statement.executeUpdate(query);

            PrintWriter printWriter = null;
            try {
                printWriter = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.println("Add new book \'" + newBook_name + "\' of " + newBook_author);

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
