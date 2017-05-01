package com;

/**
 * Created by Ник on 06.03.17.
 */
public class TypeOfFilm {
    private int idTypeOfFilm;
    private String typeFilm;

    public TypeOfFilm(int idTypeOfFilm, String typeFilm) {
        this.idTypeOfFilm = idTypeOfFilm;
        this.typeFilm = typeFilm;
    }

    public int getIdTypeOfFilm() {
        return idTypeOfFilm;
    }

    public void setIdTypeOfFilm(int idTypeOfFilm) {
        this.idTypeOfFilm = idTypeOfFilm;
    }

    public String getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(String typeFilm) {
        this.typeFilm = typeFilm;
    }
}
