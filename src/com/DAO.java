package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ник on 25.02.17.
 */
public class DAO {

    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","USER_NETCRACKER","123");
    }

    public static List<Film> getFilms() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = DAO.getConnection().prepareStatement("SELECT * from FILM").executeQuery() ){
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
    public static void deleteFilm(){

    }

    public static void main (String[] args){
        try {
            DAO.getFilms();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}