import com.*;

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
        if (!Access.isEdit()) {
            response.sendRedirect("/er?code=noPrivilege");
            return;
        }
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
                request.setAttribute("frame", FrameDAO.getFrame(id));
                request.setAttribute("posts", FilmDAO.getFilms());

                request.getRequestDispatcher("WEB-INF/frameEdit.jsp").forward(request, response);
            }
            if (table.equals("member")){
                int id = Integer.valueOf(request.getParameter("id"));
                request.setAttribute("member", MemberDAO.getMember(id));

                request.getRequestDispatcher("WEB-INF/memberEdit.jsp").forward(request, response);
            }
            if (table.equals("photo")){
                int id = Integer.valueOf(request.getParameter("id"));
                request.setAttribute("photo", PhotoDAO.getPhoto(id));
                request.setAttribute("developers", PhotoDAO.getDevelopers());
                request.setAttribute("papers", PhotoDAO.getPapers());
                request.setAttribute("frames", FrameDAO.getFrames());

                request.getRequestDispatcher("WEB-INF/photoEdit.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
