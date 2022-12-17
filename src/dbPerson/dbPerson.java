package dbPerson;

import Person.Person;

import java.util.Observable;

public abstract class dbPerson {

    public dbPerson(){}

    public abstract void addPerson(Person person);
    public abstract void deletePerson(Person person);
    public abstract void clear();
    public abstract int size();
    public abstract void printDatabase();
    public abstract Person getPersonID(int id);

}

