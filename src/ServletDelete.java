import com.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fil-n on 22.04.17.
 */
@javax.servlet.annotation.WebServlet(name = "ServletDelete", urlPatterns = "/delete")
public class ServletDelete extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (!Access.isDelete()) {
            response.sendRedirect("/er");
            return;
        }
        String table = request.getParameter("table");
        try {
            if (table.equals("film")){
                    if (!request.getParameter("id").equals("")){
                    int[] arDel = Arrays.stream(request.getParameter("id").split(",")).mapToInt(Integer::parseInt).toArray();
                    for (int id: arDel ) {
                        FilmDAO.deleteFilm(id);
                    }
                }
            }
            if (table.equals("frame")){
                int id = Integer.valueOf(request.getParameter("id"));
                FrameDAO.deleteFrame(id);
            }
            if (table.equals("member")){
                int id = Integer.valueOf(request.getParameter("id"));
                MemberDAO.deleteMember(id);
            }
            if (table.equals("photo")){
                int id = Integer.valueOf(request.getParameter("id"));
                PhotoDAO.deletePhoto(id);
            }
            response.sendRedirect("/show?table="+table);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }







    }
}
