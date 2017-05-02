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
        if (table.equals("frame")){
            //String pr = request.getParameter("idTypeOfFilm");
            Frame frame = new Frame(Date.valueOf(request.getParameter("dateFrame")), request.getParameter("placeFrame"),
                    request.getParameter("theme"), Integer.valueOf(request.getParameter("idFilm")) );
            try {
                FrameDAO.addFilm(frame);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (table.equals("photo")){
            //String pr = request.getParameter("idTypeOfFilm");
            Photo photo = null;
            try {
                photo = new Photo(Date.valueOf(request.getParameter("datePrinting")),
                        Integer.valueOf(request.getParameter("size")), Integer.valueOf(request.getParameter("number")),
                        Integer.valueOf(request.getParameter("pricePhoto")), request.getParameter("placePhoto"),
                        Integer.valueOf(request.getParameter("idDeveloper")), Integer.valueOf(request.getParameter("idPaper")),
                        Integer.valueOf(request.getParameter("idFrame")));

                        System.out.println("ЖЖЖЖЖЖЖЖЖЖ");

                        PhotoDAO.addPhoto(photo);
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
