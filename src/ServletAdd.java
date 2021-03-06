import com.Access;
import com.FilmDAO;
import com.FrameDAO;
import com.PhotoDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletAdd", urlPatterns = "/add")
public class ServletAdd extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (!Access.isAdd()) {
            response.sendRedirect("/er?code=noPrivilege");
            return;
        }
        String table = String.valueOf(request.getParameter("table"));
        try {
            if (table.equals("film")){
                request.setAttribute("posts", FilmDAO.getTypeOfFilm());
                request.getRequestDispatcher("WEB-INF/filmAdd.jsp").forward(request, response);
            }
            if (table.equals("frame")){
                request.setAttribute("posts", FilmDAO.getFilms());
                request.getRequestDispatcher("WEB-INF/frameAdd.jsp").forward(request, response);
            }
            if (table.equals("member")){
                request.getRequestDispatcher("WEB-INF/memberAdd.jsp").forward(request, response);
            }
            if (table.equals("photo")){
                request.setAttribute("developers", PhotoDAO.getDevelopers());
                request.setAttribute("papers", PhotoDAO.getPapers());
                request.setAttribute("frames", FrameDAO.getFrames());
                request.getRequestDispatcher("WEB-INF/photoAdd.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
