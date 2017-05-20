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

    public static List<Frame> getFilms() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = FrameDAO.getConnection().prepareStatement("SELECT * from Frame").executeQuery() ){
            ArrayList<Frame> frames = new ArrayList<>();
            while (rs.next()){
                frames.add(new Frame(
                        rs.getInt(1), rs.getDate(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5)
                ));
                System.out.println(rs.getInt(1)+"  "+ rs.getDate(2)+"  "+
                                rs.getString(3)+"  "+ rs.getString(4)+"  "+
                        rs.getInt(5));
            }
            return frames;
        }
    }

    public static void deleteFilm(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().prepareStatement("DELETE from FRAME WHERE ID_FRAME = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }

    public static void addFilm(Frame frame)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO FRAME VALUES (null, ?, ?, ?, ?)") ){
            prepareStatement.setDate(1, frame.getDateFrame());
            prepareStatement.setString(2, frame.getPlaceFrame());
            prepareStatement.setString(3, frame.getTheme());
            prepareStatement.setInt(4, frame.getIdFilm());
            prepareStatement.executeUpdate();
        }
    }

    public static void main (String[] args){
        try {
            FrameDAO.getFilms();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}