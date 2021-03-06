package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fil-n on 26.04.17.
 */
public class PhotoDAO extends DAO {

    public static List<Photo> getPhotos() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = PhotoDAO.getConnection().createStatement().executeQuery("SELECT P.ID_PHOTO, P.DATE_PRINTING, P.SIZE_, P.NUMBER_, P.PRICE_PHOTO, P.PLACE_PHOTO, D.NAME, B.TYPE_PAPER, P.ID_FRAME, P.ID_FILM from PHOTO P, DEVELOPER D, PAPER B WHERE P.ID_DEVELOPER = D.ID_DEVELOPER AND P.ID_PAPER = B.ID_PAPER") ){
            ArrayList<Photo> photos = new ArrayList<>();
            while (rs.next()){
                photos.add(new Photo(
                        rs.getInt(1), rs.getDate(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10)
                ));
            }
            return photos;
        }
    }

    public static void deletePhoto(int id) throws SQLException, ClassNotFoundException {
        try(PreparedStatement prepareStatement = PhotoDAO.getConnection().prepareStatement("DELETE from Photo WHERE ID_PHOTO = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }

    public static List<Developer> getDevelopers() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = PhotoDAO.getConnection().createStatement().executeQuery("SELECT * from DEVELOPER") ){
            ArrayList<Developer> developers = new ArrayList<>();
            while (rs.next()){
                developers.add(new Developer(
                        rs.getInt(1),  rs.getString(2)
                ));
            }
            return developers;
        }
    }

    public static List<Paper> getPapers() throws SQLException, ClassNotFoundException{
        try( ResultSet rs = PhotoDAO.getConnection().createStatement().executeQuery("SELECT * from PAPER") ){
            ArrayList<Paper> papers = new ArrayList<>();
            while (rs.next()){
                papers.add(new Paper(
                        rs.getInt(1),  rs.getString(2)
                ));
            }
            return papers;
        }
    }

    public static void addPhoto(Photo photo) throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO PHOTO VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)") ){

            prepareStatement.setDate(1, photo.getDatePrinting());
            prepareStatement.setInt(2, photo.getSize());
            prepareStatement.setInt(3, photo.getNumber());
            prepareStatement.setInt(4, photo.getPricePhoto());
            prepareStatement.setString(5, photo.getPlacePhoto());
            prepareStatement.setInt(6, photo.getIdDeveloper());
            prepareStatement.setInt(7, photo.getIdPaper());
            prepareStatement.setInt(8, photo.getIdFrame());
            prepareStatement.setInt(9, photo.getIdFilm());
            prepareStatement.executeUpdate();
        }
    }

    public static Photo getPhoto(int id) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = PhotoDAO.getConnection().
                prepareStatement("SELECT P.ID_PHOTO, P.DATE_PRINTING, P.SIZE_, P.NUMBER_, P.PRICE_PHOTO, P.PLACE_PHOTO, D.NAME, B.TYPE_PAPER, P.ID_FRAME, P.ID_FILM, p.ID_DEVELOPER, p.ID_PAPER from PHOTO P, DEVELOPER D, PAPER B WHERE P.ID_DEVELOPER = D.ID_DEVELOPER AND P.ID_PAPER = B.ID_PAPER AND P.ID_PHOTO = ?") ){
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            rs.next();

            Photo photo = new Photo(
                    rs.getInt(1), rs.getDate(2),
                    rs.getInt(3), rs.getInt(4),
                    rs.getInt(5), rs.getString(6),
                    rs.getString(7), rs.getString(8),
                    rs.getInt(9), rs.getInt(10),
                    rs.getInt(11), rs.getInt(12)
                    );

            return photo;
        }
    }

    public static void updatePhoto(Photo photo) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("UPDATE PHOTO SET DATE_PRINTING = ?, SIZE_ = ?, NUMBER_ = ?, PRICE_PHOTO = ?, PLACE_PHOTO = ?, ID_DEVELOPER = ?, ID_PAPER = ?, ID_FRAME = ?, ID_FILM = ? WHERE ID_PHOTO = ?") ){
            prepareStatement.setDate(1, photo.getDatePrinting());
            prepareStatement.setInt(2, photo.getSize());
            prepareStatement.setInt(3, photo.getNumber());
            prepareStatement.setInt(4, photo.getPricePhoto());
            prepareStatement.setString(5, photo.getPlacePhoto());
            prepareStatement.setInt(6, photo.getIdDeveloper());
            prepareStatement.setInt(7, photo.getIdPaper());
            prepareStatement.setInt(8, photo.getIdFrame());
            prepareStatement.setInt(9, photo.getIdFilm());
            prepareStatement.setInt(10, photo.getIdPhoto());
            prepareStatement.executeUpdate();
        }
    }
}
