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
            db.addPerson(name);
        }
        else {
            System.out.println("The given name is empty");
            db.addPerson("error");
        }
    }
}
