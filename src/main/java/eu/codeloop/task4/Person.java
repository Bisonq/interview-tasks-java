package eu.codeloop.task4;

public class Person {

    private String name;
    private String surname;
    private final String personalID;

    public Person(String name, String surname, String personalID) {
        this.name = name;
        this.surname = surname;
        this.personalID = personalID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalID='" + personalID + '\'' +
                '}';
    }
}
