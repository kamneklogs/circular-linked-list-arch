package model;

public class Person {

    private String name;
    private String id;

    private Person prevPerson;
    private Person nextPerson;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPrevPerson() {
        return prevPerson;
    }

    public void setPrevPerson(Person prevPerson) {
        this.prevPerson = prevPerson;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }

}