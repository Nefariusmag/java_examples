import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/threads")
public class MultyTreadsServlet extends HttpServlet {

    static int i = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        synchronized (this) {

            for (int j = 0; j < 1000000; j++) {
                i++;
            }
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] arg){
        for (int j=0; j < 2; j++) {
            new Thread() {
                @Override
                public void run(){
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/threads").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
