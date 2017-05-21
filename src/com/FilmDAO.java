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
        try( ResultSet rs = FilmDAO.getConnection().createStatement().executeQuery("SELECT F.ID_FILM, F.PRICE_FILM, F.SENSIBILITY, F.NUM_FRAMES, F.DATE_STARTING_SNAPSHOT, F.DATE_MANIFESTATION, F.PLACE_MANIFESTATION, F.PLACE_STORAGE, T.TYPE_FILM from FILM F, TYPEOFFILM T WHERE F.ID_TYPE_OF_FILM = T.ID_TYPE_OF_FILM") ){
            ArrayList<Film> films = new ArrayList<>();
            while (rs.next()){
                films.add(new Film(
                        rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9)
                ));
            }
            return films;
        }
    }
    public static List<TypeOfFilm> getTypeOfFilm() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = FilmDAO.getConnection().createStatement().executeQuery("SELECT * from TYPEOFFILM") ){
            ArrayList<TypeOfFilm> typeOfFilms = new ArrayList<>();
            while (rs.next()){
                typeOfFilms.add(new TypeOfFilm( rs.getInt(1), rs.getString(2) ));
                System.out.println(rs.getInt(1)+" "+ rs.getString(2));
            }
            return typeOfFilms;
        }
    }
    public static void deleteFilm(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().prepareStatement("DELETE from FILM WHERE id_Film = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }
    public static void addFilm(Film film) throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO FILM VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)") ){
            prepareStatement.setInt(1, film.getPriceFilm());
            prepareStatement.setInt(2, film.getSensibility());
            prepareStatement.setInt(3, film.getNumFrame());
            prepareStatement.setDate(4, film.getDateStartingSnapshot());
            prepareStatement.setDate(5, film.getDateManifestation());
            prepareStatement.setString(6, film.getPlaceManifestation());
            prepareStatement.setString(7, film.getPlaceStorage());
            prepareStatement.setInt(8, film.getIdTypeOfFilm());
            prepareStatement.executeUpdate();
        }
    }

    public static Film getFilm(int id) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("SELECT F.ID_FILM, F.PRICE_FILM, F.SENSIBILITY, F.NUM_FRAMES, F.DATE_STARTING_SNAPSHOT, F.DATE_MANIFESTATION, F.PLACE_MANIFESTATION, F.PLACE_STORAGE, T.TYPE_FILM, F.ID_TYPE_OF_FILM from FILM F, TYPEOFFILM T WHERE F.ID_TYPE_OF_FILM = T.ID_TYPE_OF_FILM AND F.ID_FILM = ?") ){
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            rs.next();

            Film film = new Film(
                        rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9),  rs.getInt(10)
                );

            return film;
        }
    }

    public static void undateFilm(Film film) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("UPDATE FILM SET PRICE_FILM = ?, SENSIBILITY = ?, NUM_FRAMES = ?, DATE_STARTING_SNAPSHOT = ?, DATE_MANIFESTATION = ?, PLACE_MANIFESTATION = ?, PLACE_STORAGE = ?, ID_TYPE_OF_FILM = ? WHERE ID_FILM = ?") ){
            prepareStatement.setInt(1, film.getPriceFilm());
            prepareStatement.setInt(2, film.getSensibility());
            prepareStatement.setInt(3, film.getNumFrame());
            prepareStatement.setDate(4, film.getDateStartingSnapshot());
            prepareStatement.setDate(5, film.getDateManifestation());
            prepareStatement.setString(6, film.getPlaceManifestation());
            prepareStatement.setString(7, film.getPlaceStorage());
            prepareStatement.setInt(8, film.getIdTypeOfFilm());
            prepareStatement.setInt(9, film.getIdFilm());
            prepareStatement.executeUpdate();
        }

    }
}