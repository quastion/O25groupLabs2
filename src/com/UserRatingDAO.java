package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRatingDAO extends DAO {

    public static List<UserRating> getUserRatings() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = UserRatingDAO.getConnection().createStatement().executeQuery("SELECT * from USERRATING") ){
            ArrayList<UserRating> userRatings = new ArrayList<>();
            while (rs.next()){
                userRatings.add(new UserRating(
                        rs.getInt(1), rs.getInt(2),
                        rs.getInt(3)
                ));
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+
                        rs.getInt(3));
            }
            return userRatings;
        }
    }

    public static void addUserRating(UserRating r) throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = UserRatingDAO.getConnection().
                prepareStatement("SELECT * FROM  USERRATING WHERE ID_USER= ? AND ID_FILM=?") ){
            prepareStatement.setInt(1, r.getIdUser());
            prepareStatement.setInt(2, r.getIdFilm());

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()){
                try(PreparedStatement prepareStatement2 = DAO.getConnection().
                        prepareStatement("UPDATE USERRATING set RATING = ? WHERE ID_USER = ? AND ID_FILM =?") ){

                    System.out.println("upd");
                    prepareStatement2.setInt(1, r.getRating());
                    prepareStatement2.setInt(2, r.getIdUser());
                    prepareStatement2.setInt(3, r.getIdFilm());

                    prepareStatement2.executeUpdate();
                }
            } else{
                try(PreparedStatement prepareStatement1 = DAO.getConnection().
                        prepareStatement("INSERT INTO USERRATING VALUES ( ?, ?, ?)") ){

                    prepareStatement1.setInt(1, r.getIdUser());
                    prepareStatement1.setInt(2, r.getIdFilm());
                    prepareStatement1.setInt(3, r.getRating());
                    prepareStatement1.executeUpdate();
                }
            }
        }
    }
}