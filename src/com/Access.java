package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.05.17.
 */
public class Access {
    private static int idUser;
    private static boolean read;
    private static boolean add;
    private static boolean edit;
    private static boolean delete;
    static {
        idUser = 1084;
        read = false;
        add = false;
        edit = false;
        delete = false;
    }

    public static boolean setAccess(String login, String password) throws SQLException, ClassNotFoundException {
        exit();
        try(PreparedStatement prepareStatement = DAO.getConnection().
                prepareStatement("SELECT ACCSS, ID_USER FROM USERTABLE WHERE LGN = ? AND PSW = ?") ){
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, password);
            ResultSet  rs = prepareStatement.executeQuery();
            if (rs.next()) {
                String access = rs.getString(1);

                if (access.charAt(0) == '1')  read = true;
                if (access.charAt(1) == '1')  add = true;
                if (access.charAt(2) == '1')  edit = true;
                if (access.charAt(3) == '1')  delete = true;
                //System.out.println(""+read+add+edit+delete);

                idUser = rs.getInt(2);
                return true;
            }
            else return false;
        }
    }

    public static void exit() {
        idUser = 0;
        read = false;
        add = false;
        edit = false;
        delete = false;
    }

    public static boolean isRead() {
        return read;
    }

    public static void setRead(boolean read) {
        Access.read = read;
    }

    public static boolean isAdd() {
        return add;
    }

    public static void setAdd(boolean add) {
        Access.add = add;
    }

    public static boolean isEdit() {
        return edit;
    }

    public static void setEdit(boolean edit) {
        Access.edit = edit;
    }

    public static boolean isDelete() {
        return delete;
    }

    public static void setDelete(boolean delete) {
        Access.delete = delete;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Access.idUser = idUser;
    }
}
