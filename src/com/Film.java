package com;

import java.sql.Date;

/**
 * Created by Ник on 01.03.17.
 */
public class Film {
    private int idFilm;
    private int priceFilm;
    private int sensibility;
    private int numFrame;
    private Date dateStartingSnapshot;
    private Date dateManifestation;
    private String placeManifestation;
    private String placeStorage;
    private int idTypeOfFilm;
    private String typeOfFilm;

    public Film() { }

    public Film(String placeManifestation, String placeStorage) {
        this.placeManifestation = placeManifestation;
        this.placeStorage = placeStorage;
    }

    public Film(int idFilm, int priceFilm, int sensibility, int numFrame, Date dateStartingSnapshot, Date dateManifestation, String placeManifestation, String placeStorage, String typeOfFilm) {
        this.idFilm = idFilm;
        this.priceFilm = priceFilm;
        this.sensibility = sensibility;
        this.numFrame = numFrame;
        this.dateStartingSnapshot = dateStartingSnapshot;
        this.dateManifestation = dateManifestation;
        this.placeManifestation = placeManifestation;
        this.placeStorage = placeStorage;
        this.typeOfFilm = typeOfFilm;
    }
    public Film(int idFilm, int priceFilm, int sensibility, int numFrame, Date dateStartingSnapshot, Date dateManifestation, String placeManifestation, String placeStorage, String typeOfFilm, int id_type_film) {
        this.idFilm = idFilm;
        this.priceFilm = priceFilm;
        this.sensibility = sensibility;
        this.numFrame = numFrame;
        this.dateStartingSnapshot = dateStartingSnapshot;
        this.dateManifestation = dateManifestation;
        this.placeManifestation = placeManifestation;
        this.placeStorage = placeStorage;
        this.typeOfFilm = typeOfFilm;
        this.idTypeOfFilm=id_type_film;
    }
    public Film( int priceFilm, int sensibility, int numFrame, Date dateStartingSnapshot, Date dateManifestation, String placeManifestation, String placeStorage, int idTypeOfFilm) {
        this.priceFilm = priceFilm;
        this.sensibility = sensibility;
        this.numFrame = numFrame;
        this.dateStartingSnapshot = dateStartingSnapshot;
        this.dateManifestation = dateManifestation;
        this.placeManifestation = placeManifestation;
        this.placeStorage = placeStorage;
        this.idTypeOfFilm = idTypeOfFilm;
    }

    public Film(int idFilm, int sensibility, int numFrame, Date dateStartingSnapshot, String placeManifestation) {
        this.idFilm = idFilm;
        this.sensibility = sensibility;
        this.numFrame = numFrame;
        this.dateStartingSnapshot = dateStartingSnapshot;
        this.placeManifestation = placeManifestation;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getPriceFilm() {
        return priceFilm;
    }

    public void setPriceFilm(int priceFilm) {
        this.priceFilm = priceFilm;
    }

    public int getSensibility() {
        return sensibility;
    }

    public void setSensibility(int sensibility) {
        this.sensibility = sensibility;
    }

    public int getNumFrame() {
        return numFrame;
    }

    public void setNumFrame(int numFrame) {
        this.numFrame = numFrame;
    }

    public Date getDateStartingSnapshot() {
        return dateStartingSnapshot;
    }

    public void setDateStartingSnapshot(Date dateStartingSnapshot) {
        this.dateStartingSnapshot = dateStartingSnapshot;
    }

    public Date getDateManifestation() {
        return dateManifestation;
    }

    public void setDateManifestation(Date dateManifestation) {
        this.dateManifestation = dateManifestation;
    }

    public String getPlaceManifestation() {
        return placeManifestation;
    }

    public void setPlaceManifestation(String placeManifestation) {
        this.placeManifestation = placeManifestation;
    }

    public String getPlaceStorage() {
        return placeStorage;
    }

    public void setPlaceStorage(String placeStorage) {
        this.placeStorage = placeStorage;
    }

    public int getIdTypeOfFilm() {
        return idTypeOfFilm;
    }

    public void setIdTypeOfFilm(int idTypeOfFilm) {
        this.idTypeOfFilm = idTypeOfFilm;
    }


    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", priceFilm=" + priceFilm +
                ", sensibility=" + sensibility +
                ", numFrame=" + numFrame +
                ", dateStartingSnapshot=" + dateStartingSnapshot +
                ", dateManifestation=" + dateManifestation +
                ", placeManifestation='" + placeManifestation + '\'' +
                ", placeStorage='" + placeStorage + '\'' +
                ", idTypeOfFilm=" + idTypeOfFilm +
                '}';
    }

    public String getTypeOfFilm() {
        return typeOfFilm;
    }

    public void setTypeOfFilm(String typeOfFilm) {
        this.typeOfFilm = typeOfFilm;
    }
}
