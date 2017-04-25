package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 25.02.17.
 */
public class MemberDAO extends DAO {

    public static List<Member> getFilms() throws SQLException, ClassNotFoundException {
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
    public static void deleteFilm(){

    }

    public static void main (String[] args){
        try {
            MemberDAO.getFilms();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}