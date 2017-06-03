import com.*;

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
        if (!Access.isRead()) {
            response.sendRedirect("/er?code=noPrivilege");
            return;
        }
        request.setAttribute("idUser", Access.getIdUser() );
        request.setAttribute("edit", Access.isEdit() );
        request.setAttribute("delete", Access.isDelete() );
        String table = String.valueOf(request.getParameter("table"));
        try {
            if (table.equals("film")){
                request.setAttribute("posts", FilmDAO.getFilms());
                request.setAttribute("rat", UserRatingDAO.getRatings(Access.getIdUser()));
                request.getRequestDispatcher("WEB-INF/filmShow.jsp").forward(request, response);
            }
            if (table.equals("frame")){
                request.setAttribute("posts", FrameDAO.getFrames());
                request.getRequestDispatcher("WEB-INF/frameShow.jsp").forward(request, response);
            }
            if (table.equals("member")){
                request.setAttribute("posts", MemberDAO.getMembers());
                request.getRequestDispatcher("WEB-INF/memberShow.jsp").forward(request, response);
            }
            if (table.equals("photo")){
                request.setAttribute("posts", PhotoDAO.getPhotos());
                request.getRequestDispatcher("WEB-INF/photoShow.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
