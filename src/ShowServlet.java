import com.DAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Ник on 01.03.17.
 */
@javax.servlet.annotation.WebServlet(name = "ShowServlet", urlPatterns = "/show")
public class ShowServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.setAttribute("films", DAO.getFilms());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/films.jsp").forward(request, response);
    }
}
