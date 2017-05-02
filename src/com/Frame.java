package com;

import java.sql.Date;

/**
 * Created by Ник on 06.03.17.
 */
public class Frame {
    private int idFrame;
    private Date dateFrame;
    private String placeFrame;
    private String theme;
    private int idFilm;

    public Frame(int idFrame, Date dateFrame, String placeFrame, String theme, int idFilm) {
        this.idFrame = idFrame;
        this.dateFrame = dateFrame;
        this.placeFrame = placeFrame;
        this.theme = theme;
        this.idFilm = idFilm;
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
}
