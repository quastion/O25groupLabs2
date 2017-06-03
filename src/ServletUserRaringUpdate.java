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
@WebServlet(name = "ServletUserRaringUpdate", urlPatterns = "/userratingupdate")
public class ServletUserRaringUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain");
            int idUser = Integer.valueOf(request.getParameter("idUser"));
            int idFilm = Integer.valueOf(request.getParameter("idFilm"));
            int numStar = Integer.valueOf(request.getParameter("numStar"));

            int rating = UserRatingDAO.getUserRating(idUser, idFilm);
            if(rating!=-1){
                PrintWriter out = response.getWriter();
                //Если номер звезды совпадает с оценкой, тогда закрашиваем ее
                //иначе не трогаем
                if(numStar == rating)
                    out.print("true");
                else
                    out.print("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
