import com.FilmDAO;
import com.FrameDAO;
import com.MemberDAO;
import com.PhotoDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletShow", urlPatterns = "/show")
public class ServletShow extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String table = String.valueOf(request.getParameter("table"));
        try {
            if (table.equals("film")){

                request.setAttribute("posts", FilmDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/filmShow.jsp").forward(request, response);
            }
            if (table.equals("frame")){
                request.setAttribute("posts", FrameDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/frameShow.jsp").forward(request, response);
            }
            if (table.equals("member")){
                request.setAttribute("posts", MemberDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/memberShow.jsp").forward(request, response);
            }
            if (table.equals("photo")){
                request.setAttribute("posts", PhotoDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/photoShow.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("AAA!!!A");
    }
}
