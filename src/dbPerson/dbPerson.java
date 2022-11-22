package dbPerson;

import Person.Person;

import java.util.Observable;

public abstract class dbPerson extends Observable {
    public dbPerson(){}

    public abstract void addPerson(String name);

    public abstract void deletePerson(String name);

    public abstract int size();
    public abstract void Loop();
}

