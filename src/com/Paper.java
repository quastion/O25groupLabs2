package com;

/**
 * Created by Ник on 06.03.17.
 */
public class Paper {
    private int idPaper;
    private String typePaper;

    public Paper(int idPaper, String typePaper) {
        this.idPaper = idPaper;
        this.typePaper = typePaper;
    }

    public String getTypePaper() {
        return typePaper;
    }

    public void setTypePaper(String typePaper) {
        this.typePaper = typePaper;
    }

    public int getIdPaper() {
        return idPaper;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper = idPaper;
    }
}
