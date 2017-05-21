import com.FilmDAO;
import com.FrameDAO;
import com.MemberDAO;
import com.PhotoDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletEdit", urlPatterns = "/edit")
public class ServletEdit extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String table = request.getParameter("table");
        try {
            if (table.equals("film")){
                int id = Integer.valueOf(request.getParameter("id"));
                request.setAttribute("film", FilmDAO.getFilm(id));
                request.setAttribute("posts", FilmDAO.getTypeOfFilm());
                request.getRequestDispatcher("WEB-INF/filmEdit.jsp").forward(request, response);
            }
            if (table.equals("frame")){
                int id = Integer.valueOf(request.getParameter("id"));
                FrameDAO.deleteFrame(id);
                response.sendRedirect("/show?table="+table);
            }
            if (table.equals("member")){
                int id = Integer.valueOf(request.getParameter("id"));
                MemberDAO.deleteMember(id);
                response.sendRedirect("/show?table="+table);
            }
            if (table.equals("photo")){
                int id = Integer.valueOf(request.getParameter("id"));
                PhotoDAO.deletePhoto(id);
                response.sendRedirect("/show?table="+table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }







    }
}
