import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fil-n on 19.05.17.
 */
@WebServlet(name = "ServletError", urlPatterns = "/er")
public class ServletError extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("code").equals("noAccess")){
            request.setAttribute("e", "Неверный логин/пароль.");
            request.setAttribute("code", 1);
        }
        if (request.getParameter("code").equals("noPrivilege")){
            request.setAttribute("e", "Недостаточно прав.");
            request.setAttribute("code", 2);
        }

        request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
    }
}
