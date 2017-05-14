package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

    public static List<User> getUsers() throws SQLException, ClassNotFoundException {
        try( ResultSet rs = UserDAO.getConnection().createStatement().executeQuery("SELECT * from USER") ){
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)
                ));
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+
                        rs.getString(3)+"  "+ rs.getString(4));
            }
            return users;
        }
    }

    public static void addUser(User user) throws SQLException, ClassNotFoundException{
        try(PreparedStatement prepareStatement = UserDAO.getConnection().
                prepareStatement("INSERT INTO USER VALUES (null, ?, ?, ?)") ){
            prepareStatement.setString(1, user.getLogin());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getAccess());
            prepareStatement.executeUpdate();
        }
    }
}
