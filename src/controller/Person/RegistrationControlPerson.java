package controller.Person;

import dbPerson.dbPerson;

public class RegistrationControlPerson implements Controller{
    private dbPerson db;
    public RegistrationControlPerson(dbPerson db){
        this.db = db;
    }

    @Override
    public void ConfirmName(String name) {
        if(name.isEmpty()){
            System.out.println("The given name is empty");
            db.addPerson("error");
        }
        else {

            db.addPerson(name);
            System.out.println(name + " is added in the database");
        }
    }
}
