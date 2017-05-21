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
@WebServlet(name = "ServletEditPost", urlPatterns = "/editpost")
public class ServletEditPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String table = String.valueOf(request.getParameter("table"));
            if (table.equals("film")){
                Film film = new Film(Integer.valueOf(request.getParameter("priceFilm")), Integer.valueOf(request.getParameter("sensibility")),
                        Integer.valueOf(request.getParameter("numFrame")), Date.valueOf(request.getParameter("dateStartingSnapshot")),
                        Date.valueOf(request.getParameter("dateManifestation")), request.getParameter("placeManifestation"),
                        request.getParameter("placeStorage"), Integer.valueOf(request.getParameter("idTypeOfFilm")) );
                film.setIdFilm(Integer.valueOf(request.getParameter("id")));

                FilmDAO.undateFilm(film);

            }
            if (table.equals("member")){
                Member member = new Member(request.getParameter("surname"), request.getParameter("name"),
                        request.getParameter("middleName") );
                member.setIdMember(Integer.valueOf(request.getParameter("id")));

                MemberDAO.updateMember(member);
            }
            if (table.equals("frame")){
                Frame frame = new Frame(Date.valueOf(request.getParameter("dateFrame")), request.getParameter("placeFrame"),
                        request.getParameter("theme"), Integer.valueOf(request.getParameter("idFilm")) );
                frame.setIdFrame(Integer.valueOf(request.getParameter("id")));

                FrameDAO.updateFrame(frame);

            }
            if (table.equals("photo")) {
                Photo photo = new Photo(Date.valueOf(request.getParameter("datePrinting")),
                        Integer.valueOf(request.getParameter("size")), Integer.valueOf(request.getParameter("number")),
                        Integer.valueOf(request.getParameter("pricePhoto")), request.getParameter("placePhoto"),
                        Integer.valueOf(request.getParameter("idDeveloper")), Integer.valueOf(request.getParameter("idPaper")),
                        Integer.valueOf(request.getParameter("idFrame")));
                photo.setIdPhoto(Integer.valueOf(request.getParameter("id")));

                PhotoDAO.updatePhoto(photo);
            }
            response.sendRedirect("/show?table="+table);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
    }
}
