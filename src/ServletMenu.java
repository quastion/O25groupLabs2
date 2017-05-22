import com.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletMenu", urlPatterns = "/menu")
public class ServletMenu extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            if (Access.setAccess(request.getParameter("login"), request.getParameter("password")))
                request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
            else {response.sendRedirect("/er?code=noAccess");}
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
    }
}
