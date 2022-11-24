package observer.Person;

import Person.Person;
import dbPerson.dbPerson;

import java.util.Observable;
import java.util.Observer;

import static sun.misc.Version.print;

public class PrintObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        dbPerson db = (dbPerson) o;
        print((Person) arg, String.valueOf(db.getPerson()));
    }
    private void print(Person p, String Name){
        System.out.println(p.getName());
    }


}

