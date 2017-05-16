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

    public static void addUserRating(UserRating userRating) throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = UserRatingDAO.getConnection().
                prepareStatement("INSERT INTO USERRATING VALUES (?, ?, ?)") ){
            prepareStatement.setInt(1, userRating.getIdUser());
            prepareStatement.setInt(2, userRating.getIdFilm());
            prepareStatement.setInt(3, userRating.getRating());
            prepareStatement.executeUpdate();
        }
    }
}