package controller.Person;

import Person.Person;
import dbPerson.dbPerson;

public interface Controller {
    void ConfirmName(String Name);
    void ControlName(dbPerson db, String Name);
}
