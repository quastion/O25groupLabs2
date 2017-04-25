package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ник on 25.02.17.
 */
public class FilmDAO extends DAO {

    public static List<Film> getFilms() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = FilmDAO.getConnection().createStatement().executeQuery("SELECT * from FILM") ){
            ArrayList<Film> films = new ArrayList<>();
            while (rs.next()){
                films.add(new Film(
                        rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getString(7), rs.getString(8),
                        rs.getInt(9)
                ));
                System.out.println(rs.getInt(1)+"   "+rs.getInt(2)
                        +"   "+rs.getInt(3)+"   "+rs.getInt(4)
                        +"   "+rs.getDate(5)+"    "+rs.getDate(6)
                        +"   "+rs.getString(7)+"   "+rs.getString(8)
                        +"   "+ rs.getInt(9));
            }
            return films;
        }
    }
    public static void deleteFilm(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().prepareStatement("DELETE from FILM WHERE ifFilm = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }
    public static void addFilm(Film film)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO FILM VALUES (null, ?, ?, ?, ?, ?, ?, ?, 1005);") ){
            //INSERT INTO FILM VALUES (null, 22, 33, 44, TO_DATE('11-12-2000'), TO_DATE('11-12-2000'), 'ТОльятти','ТОльятти', 1005);
            prepareStatement.setInt(1, film.getPriceFilm());
            prepareStatement.setInt(2, film.getSensibility());
            prepareStatement.setInt(3, film.getNumFrame());
            prepareStatement.setDate(4, film.getDateStartingSnapshot());
            prepareStatement.setDate(5, film.getDateManifestation());
            prepareStatement.setString(6, film.getPlaceManifestation());
            prepareStatement.setString(7, film.getPlaceStorage());
            prepareStatement.executeUpdate();
        }
    }

    public static void main (String[] args){
        try {
            FilmDAO.getFilms();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}