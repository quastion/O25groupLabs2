package com;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ник on 06.03.17.
 */
public class Frame {
    private int idFrame;
    private Date dateFrame;
    private String placeFrame;
    private String theme;
    private int idFilm;
    private Film film;
    public Frame(){}

    public Frame(int idFrame, Date dateFrame, String placeFrame, String theme, int idFilm) throws SQLException, ClassNotFoundException {
        this.idFrame = idFrame;
        this.dateFrame = dateFrame;
        this.placeFrame = placeFrame;
        this.theme = theme;
        this.idFilm = idFilm;

        try( PreparedStatement prepareStatement = PhotoDAO.getConnection().
                prepareStatement("SELECT SENSIBILITY, NUM_FRAMES, DATE_STARTING_SNAPSHOT, PLACE_MANIFESTATION from FILM WHERE ID_FILM = ?") ){
            prepareStatement.setInt(1, idFilm);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            this.film = new Film(idFilm, resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getDate(3), resultSet.getString(4) );
            }
        System.out.println(this);
    }
    public Frame(Date dateFrame, String placeFrame, String theme, int idFilm) {
        this.dateFrame = dateFrame;
        this.placeFrame = placeFrame;
        this.theme = theme;
        this.idFilm = idFilm;
    }

    public int getIdFrame() {
        return idFrame;
    }

    public void setIdFrame(int idFrame) {
        this.idFrame = idFrame;
    }

    public Date getDateFrame() {
        return dateFrame;
    }

    public void setDateFrame(Date dateFrame) {
        this.dateFrame = dateFrame;
    }

    public String getPlaceFrame() {
        return placeFrame;
    }

    public void setPlaceFrame(String placeFrame) {
        this.placeFrame = placeFrame;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "idFrame=" + idFrame +
                ", dateFrame=" + dateFrame +
                ", placeFrame='" + placeFrame + '\'' +
                ", theme='" + theme + '\'' +
                ", idFilm=" + idFilm +
                ", film=" + film +
                '}';
    }
}
