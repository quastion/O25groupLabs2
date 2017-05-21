package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 25.02.17.
 */
public class MemberDAO extends DAO {

    public static List<Member> getMember() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = MemberDAO.getConnection().prepareStatement("SELECT * from Member").executeQuery() ){
            ArrayList<Member> members = new ArrayList<>();
            while (rs.next()){
                members.add(new Member(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)
                ));
                System.out.println(rs.getInt(1)+"  "+ rs.getString(2)+"  "+
                        rs.getString(3)+"  "+ rs.getString(4));
            }
            return members;
        }
    }

    public static void deleteMember(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().prepareStatement("DELETE from MEMBER WHERE id_Member = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }
    public static void addFilm(Member film)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO Member VALUES (null, ?, ?, ?)") ){
            prepareStatement.setString(1, film.getSurname());
            prepareStatement.setString(2, film.getName());
            prepareStatement.setString(3, film.getMiddleName());
            prepareStatement.executeUpdate();
        }
    }

    public static void main (String[] args){
        try {
            MemberDAO.getMember();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}