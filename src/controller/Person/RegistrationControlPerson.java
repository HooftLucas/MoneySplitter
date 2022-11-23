package controller.Person;

import Person.Person;
import dbPerson.dbPerson;

public class RegistrationControlPerson implements Controller{
    private dbPerson db;
    public RegistrationControlPerson(dbPerson db){
        this.db = db;
    }

    @Override
    public void ConfirmName(Person person) {
        if(person.getName().isEmpty()){
            System.out.println("The given name is empty");

        }
        else {
            db.addPerson(person);
            System.out.println(person.getName() + " is added in the database");
        }
    }
}
