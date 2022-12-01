package controller.Person;

import Person.Person;
import dbPerson.dbPerson;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistrationControlPerson implements Controller{
    private dbPerson db;
    public RegistrationControlPerson(dbPerson db){
        this.db = db;
    }

    @Override
    public void ConfirmName(String Name) {
        if(Name.isEmpty()){
            System.out.println("The given name is empty");

        }
        else {
            ControlName(db,Name);
        }
    }

    @Override
    public void ControlName(dbPerson db, String Name) {
        boolean nameInDb = true;
        if (db.size() != 0) {
            for (int i = 0; i < db.size(); i++) {
                if (db.getPersonID(i).getName() == Name) {
                    System.out.println(Name+" is already in the DB: ");
                    nameInDb = true;
                    return;
                } else
                    nameInDb = false;
            }
            if (!nameInDb) {
                db.addPerson(new Person(Name));
                System.out.println(Name + " is added in the database");

            }
        }
    }
}
