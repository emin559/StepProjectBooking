package app.entities;

public class Person {
  private String name;
  private String surname;

  public Person(String name, String surName) {
    this.name = name;
    this.surname = surName;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  @Override
  public String toString() {
    return String.format("name='%s', surname='%s'}", name, surname);
  }
}
