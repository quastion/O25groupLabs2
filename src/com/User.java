package com;

import java.sql.Date;

public class User {
    private int idUser;
    private String login;
    private String Password;
    private String Access;

    public User() { }

    public User(int idUser, String login, String Password, String Access) {
        this.idUser = idUser;
        this.login = login;
        this.Password = Password;
        this.Access = Access;
    }

    public User(String login, String Password, String Access) {
        this.login = login;
        this.Password = Password;
        this.Access = Access;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAccess() {
        return Access;
    }

    public void setAccess(String access) {
        Access = access;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", Password='" + Password + '\'' +
                ", Access='" + Access + '\'' +
                '}';
    }
}
