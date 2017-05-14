package com;

import java.sql.Date;

public class UserRating {
    private int idUser;
    private int idFilm;
    private int rating;
    public User() { }

    public Film(int idUser, int idFilm, int rating) {
        this.idUser = idUser;
        this.idFilm = idFilm;
        this.rating = rating;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserRating{" +
                "idUser=" + idUser +
                ", idFilm=" + idFilm +
                ", rating=" + rating +
                '}';
    }
}