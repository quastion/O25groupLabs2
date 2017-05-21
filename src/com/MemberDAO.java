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

    public static List<Member> getMembers() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = MemberDAO.getConnection().prepareStatement("SELECT * from Member").executeQuery() ){
            ArrayList<Member> members = new ArrayList<>();
            while (rs.next()){
                members.add(new Member(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)
                ));
            }
            return members;
        }
    }

    public static void deleteMember(int id)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = MemberDAO.getConnection().prepareStatement("DELETE from MEMBER WHERE id_Member = ?") ){
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }
    public static void addFilm(Member member)throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("INSERT INTO Member VALUES (null, ?, ?, ?)") ){
            prepareStatement.setString(1, member.getSurname());
            prepareStatement.setString(2, member.getName());
            prepareStatement.setString(3, member.getMiddleName());
            prepareStatement.executeUpdate();
        }
    }

    public static Member getMember(int id) throws SQLException, ClassNotFoundException {
        try( PreparedStatement prepareStatement = MemberDAO.getConnection().prepareStatement("SELECT * from Member WHERE ID_MEMBER = ?") ){
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            rs.next();

            Member member = new Member(
                    rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)
            );

            return member;
        }
    }

    public static void updateMember(Member member) throws SQLException, ClassNotFoundException {
        try(PreparedStatement prepareStatement = FilmDAO.getConnection().
                prepareStatement("UPDATE MEMBER set SURNAME = ?, NAME = ?, MIDDLE_NAME = ? WHERE ID_MEMBER = ? ")){
            prepareStatement.setString(1, member.getSurname());
            prepareStatement.setString(2, member.getName());
            prepareStatement.setString(3, member.getMiddleName());
            prepareStatement.setInt(4, member.getIdMember());
            prepareStatement.executeUpdate();
        }
    }
}