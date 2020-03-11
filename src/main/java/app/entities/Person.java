package app.entities;

public class Person {
    private int ID;
    private String name;
    private String surname;

    public Person(int ID, String name, String surName) {
        this.ID = ID;
        this.name = name;
        this.surname = surName;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
