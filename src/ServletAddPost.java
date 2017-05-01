import com.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by fil-n on 25.04.17.
 */
@WebServlet(name = "ServletAddPost", urlPatterns = "/addpost")
public class ServletAddPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = String.valueOf(request.getParameter("table"));
        if (table.equals("film")){
            //String pr = request.getParameter("idTypeOfFilm");
            Film film = new Film(Integer.valueOf(request.getParameter("priceFilm")), Integer.valueOf(request.getParameter("sensibility")),
                    Integer.valueOf(request.getParameter("numFrame")), Date.valueOf(request.getParameter("dateStartingSnapshot")),
                    Date.valueOf(request.getParameter("dateManifestation")), request.getParameter("placeManifestation"),
                    request.getParameter("placeStorage"), Integer.valueOf(request.getParameter("idTypeOfFilm")) );
            try {
                FilmDAO.addFilm(film);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (table.equals("member")){
            //String pr = request.getParameter("idTypeOfFilm");
            Member member = new Member(request.getParameter("surname"), request.getParameter("name"),
                    request.getParameter("middleName") );
            try {
                MemberDAO.addFilm(member);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
