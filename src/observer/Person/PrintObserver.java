package observer.Person;

import Person.Person;
import dbPerson.dbPerson;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import static sun.misc.Version.print;

public class PrintObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        dbPerson db = (dbPerson) o;
        print((Person) arg ); // hierachter moeten de kosten van de rekening komen
    }
    private void print(Person p){
        System.out.println("name: "+ p.getName());
    }


}

