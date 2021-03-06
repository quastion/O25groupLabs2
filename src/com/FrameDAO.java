package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 25.02.17.
 */
public class FrameDAO extends DAO {

    public static List<Frame> getFrames() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = FrameDAO.getConnection().prepareStatement("SELECT * from Frame").executeQuery() ){
            ArrayList<Frame> frames = new ArrayList<>();
            while (rs.next()){
                frames.add(new Frame(
                        rs.getInt(1), rs.getDate(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5)
                ));
            }
            return frames;
        }
    }

    public static void deleteFrame(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().prepareStatement("DELETE from FRAME WHERE ID_FRAME = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }

    public static void addFrame(Frame frame)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO FRAME VALUES (null, ?, ?, ?, ?)") ){
            prepareStatement.setDate(1, frame.getDateFrame());
            prepareStatement.setString(2, frame.getPlaceFrame());
            prepareStatement.setString(3, frame.getTheme());
            prepareStatement.setInt(4, frame.getIdFilm());
            prepareStatement.executeUpdate();
        }
    }

    public static Frame getFrame(int id) throws SQLException, ClassNotFoundException {
        try(PreparedStatement prepareStatement = FrameDAO.getConnection().
                prepareStatement("SELECT * from Frame where ID_FRAME = ?") ){
            prepareStatement.setInt(1, id);

            ResultSet rs = prepareStatement.executeQuery();
            rs.next();
            Frame frame = new Frame(
                    rs.getInt(1), rs.getDate(2),
                    rs.getString(3), rs.getString(4),
                    rs.getInt(5)
            );
            return frame;
        }
    }

    public static void updateFrame(Frame frame) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = FrameDAO.getConnection().
                prepareStatement("UPDATE FRAME SET DATE_FRAME = ?, PLACE_FRAME = ?, THEME = ?, ID_FILM = ? WHERE ID_FRAME = ?") ){
            prepareStatement.setDate(1, frame.getDateFrame());
            prepareStatement.setString(2, frame.getPlaceFrame());
            prepareStatement.setString(3, frame.getTheme());
            prepareStatement.setInt(4, frame.getIdFilm());
            prepareStatement.setInt(5, frame.getIdFrame());
            prepareStatement.executeUpdate();
        }
    }
}