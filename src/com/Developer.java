package com;

/**
 * Created by Ник on 06.03.17.
 */
public class Developer {
    private int idDeveloper;
    private String name;

    public Developer(int idDeveloper, String name) {
        this.idDeveloper = idDeveloper;
        this.name = name;
    }


    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
