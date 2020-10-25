import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

@WebServlet("/gzip")
public class GZipServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getHeader("Accept-Encoding").contains("gzip")) {
            response.setHeader("Content-Encoding", "gzip");
            PrintWriter writer = new PrintWriter(new GZIPOutputStream(response.getOutputStream()));
            writer.println("Hello World!");
            writer.flush();
            writer.close();
        }

    }
}
