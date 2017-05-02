import com.FilmDAO;
import com.FrameDAO;
import com.MemberDAO;
import com.PhotoDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletDelete", urlPatterns = "/delete")
public class ServletDelete extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String table = String.valueOf(request.getParameter("table"));
        try {
            if (table.equals("film")){
                int id = Integer.valueOf(request.getParameter("id"));
                FilmDAO.deleteFilm(id);
                response.sendRedirect("/show?table="+table);
            }
            if (table.equals("frame")){
                request.setAttribute("posts", FrameDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/frameShow.jsp").forward(request, response);
            }
            if (table.equals("member")){
                int id = Integer.valueOf(request.getParameter("id"));
                MemberDAO.deleteFilm(id);
                response.sendRedirect("/show?table="+table);
            }
            if (table.equals("photo")){
                int id = Integer.valueOf(request.getParameter("id"));
                PhotoDAO.deleteFilm(id);
                response.sendRedirect("/show?table="+table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }







    }
}
