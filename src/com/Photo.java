package com;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fil-n on 22.04.17.
 */
public class Photo {
    private int idPhoto;
    private Date datePrinting;
    private int size;
    private int number;
    private int pricePhoto;
    private String placePhoto;
    private int idDeveloper;
    private String developer;
    private int idPaper;
    private String paper;
    private int idFrame;
    private int idFilm;
    private Frame frame;

    public String getPlacePhoto() {
        return placePhoto;
    }

    public void setPlacePhoto(String placePhoto) {
        this.placePhoto = placePhoto;
    }

    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public int getIdPaper() {
        return idPaper;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper = idPaper;
    }

    public int getIdFrame() {
        return idFrame;
    }

    public void setIdFrame(int idFrame) {
        this.idFrame = idFrame;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }


    public Photo(int idPhoto, Date datePrinting, int size, int number, int pricePhoto, String placePhoto, int idDeveloper, int idPaper, int idFrame, int idFilm) {
        this.idPhoto = idPhoto;
        this.datePrinting = datePrinting;
        this.size = size;
        this.number = number;
        this.pricePhoto = pricePhoto;
        this.placePhoto = placePhoto;
        this.idDeveloper = idDeveloper;
        this.idPaper = idPaper;
        this.idFrame = idFrame;
        this.idFilm = idFilm;
    }
    public Photo(Date datePrinting, int size, int number, int pricePhoto, String placePhoto, int idDeveloper, int idPaper, int idFrame) throws SQLException, ClassNotFoundException {
        this.datePrinting = datePrinting;
        this.size = size;
        this.number = number;
        this.pricePhoto = pricePhoto;
        this.placePhoto = placePhoto;
        this.idDeveloper = idDeveloper;
        this.idPaper = idPaper;
        this.idFrame = idFrame;
        //int idFilm;
        try(PreparedStatement prepareStatement = PhotoDAO.getConnection().
                prepareStatement("SELECT ID_FILM from FRAME WHERE ID_FRAME = ?")){
            prepareStatement.setInt(1, idFrame);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getInt(1));
            this.idFilm = resultSet.getInt(1);
        }

    }
    public Photo(int idPhoto, Date datePrinting, int size, int number, int pricePhoto, String placePhoto, String developer, String paper, int idFrame, int idFilm) throws SQLException, ClassNotFoundException {
        this.idPhoto = idPhoto;
        this.datePrinting = datePrinting;
        this.size = size;
        this.number = number;
        this.pricePhoto = pricePhoto;
        this.placePhoto = placePhoto;
        this.developer = developer;
        this.paper = paper;
        this.idFrame = idFrame;
        this.idFilm = idFilm;

        try(PreparedStatement prepareStatement = PhotoDAO.getConnection().
                prepareStatement("SELECT ID_FILM, DATE_FRAME, PLACE_FRAME, THEME from FRAME WHERE ID_FRAME = ?")){
            prepareStatement.setInt(1, idFrame);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();

            this.idFilm = resultSet.getInt(1);
            this.frame = new Frame(resultSet.getDate(2), resultSet.getString(3), resultSet.getString(4), this.idFilm);
        }

    }
    public Photo(int idPhoto, Date datePrinting, int size, int number, int pricePhoto, String placePhoto, String developer, String paper, int idFrame, int idFilm, int idDeveloper, int idPaper) throws SQLException, ClassNotFoundException {
        this.idPhoto = idPhoto;
        this.datePrinting = datePrinting;
        this.size = size;
        this.number = number;
        this.pricePhoto = pricePhoto;
        this.placePhoto = placePhoto;
        this.developer = developer;
        this.paper = paper;
        this.idFrame = idFrame;
        this.idFilm = idFilm;
        this.idDeveloper = idDeveloper;
        this.idPaper=idPaper;

        try(PreparedStatement prepareStatement = PhotoDAO.getConnection().
                prepareStatement("SELECT ID_FILM, DATE_FRAME, PLACE_FRAME, THEME from FRAME WHERE ID_FRAME = ?")){
            prepareStatement.setInt(1, idFrame);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            this.idFilm = resultSet.getInt(1);
            this.frame = new Frame(resultSet.getDate(2), resultSet.getString(3), resultSet.getString(4), this.idFilm);
        }

    }


    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Date getDatePrinting() {
        return datePrinting;
    }

    public void setDatePrinting(Date datePrinting) {
        this.datePrinting = datePrinting;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPricePhoto() {
        return pricePhoto;
    }

    public void setPricePhoto(int pricePhoto) {
        this.pricePhoto = pricePhoto;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "idPhoto=" + idPhoto +
                ", datePrinting=" + datePrinting +
                ", size=" + size +
                ", number=" + number +
                ", pricePhoto=" + pricePhoto +
                ", placePhoto='" + placePhoto + '\'' +
                ", idDeveloper=" + idDeveloper +
                ", developer='" + developer + '\'' +
                ", idPaper=" + idPaper +
                ", paper='" + paper + '\'' +
                ", idFrame=" + idFrame +
                ", idFilm=" + idFilm +
                ", frame=" + frame +
                '}';
    }
}
