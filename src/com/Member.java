package com;

/**
 * Created by Ник on 06.03.17.
 */
public class Member {
    private int idMember;
    private String surname;
    private String name;
    private String middleName;

    public Member(int idMember, String surname, String name, String middleName) {
        this.idMember = idMember;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
