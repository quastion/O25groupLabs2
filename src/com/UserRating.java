package com;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRating {
    private int idUser;
    private int idFilm;
    private int rating;
    public UserRating() { }


    public UserRating(int idUser, int idFilm, int rating) {
        this.idUser = idUser;
        this.idFilm = idFilm;
        this.rating = rating;
    }

    public int getIdUser() {
        return idUser;
    }

    public static void saveUserRating(UserRating r) throws SQLException, ClassNotFoundException {
        try(PreparedStatement prepareStatement = DAO.getConnection().
                prepareStatement("INSERT INTO USERRATING VALUES ( ?, ?, ?)") ){
            prepareStatement.setInt(1, r.getIdUser());
            prepareStatement.setInt(2, r.getIdFilm());
            prepareStatement.setInt(3, r.getRating());
            prepareStatement.executeUpdate();
        }
    }


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserRating{" +
                "idUser=" + idUser +
                ", idFilm=" + idFilm +
                ", rating=" + rating +
                '}';
    }
}