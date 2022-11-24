package observer.Person;

import Person.Person;
import dbPerson.dbPerson;

import java.util.Observable;
import java.util.Observer;

public class EntryPrinter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        dbPerson db = (dbPerson) o;
       db.printDatabase();
    }
}
