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



    }
    private void print(Person p){
        System.out.println("name: "+ p.getName());
    }


}

    public void ControlName(dbPerson db, String Name) {
        boolean nameInDb = true;
        for (int i = 0; i < db.size(); i++) {
            if(db.getPersonID(i).getName() == Name){
                i = db.size();
                System.out.println("Name is in the DB" + Name);
                nameInDb = true;
                return;
            }
            else
                nameInDb = false;
        }
        if (!nameInDb){
            db.addPerson(new Person(Name));
        }