import com.FilmDAO;
import com.UserRating;
import com.UserRatingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by fil-n on 23.05.17.
 */
@WebServlet(name = "ServletUserRaring", urlPatterns = "/userrating")
public class ServletUserRaring extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain");
            int userRating = Integer.valueOf(request.getParameter("mark"));
            int idUser = Integer.valueOf(request.getParameter("idUser"));
            int idFilm = Integer.valueOf(request.getParameter("idFilm"));

            UserRatingDAO.addUserRating(new UserRating(idUser, idFilm, userRating));

            PrintWriter out = response.getWriter();
            out.print(""+FilmDAO.getFilm(idFilm).getRating()+" / 5");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
