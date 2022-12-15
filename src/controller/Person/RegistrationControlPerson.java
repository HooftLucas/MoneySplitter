package controller.Person;

import Person.Person;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;

public class RegistrationControlPerson implements Controller{
    private final dbPerson dbPerson;

    public RegistrationControlPerson(dbPerson dbPerson){
        this.dbPerson = dbPerson;
    }

    @Override
    public void addNameToDatabase(String Name) {
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        boolean nameInDb = true;

        if(Name.isEmpty()){
            System.out.println("The given name is empty");
        }
        else {
            if(dbPerson.size() == 0) {
                dbPerson.addPerson(new Person(Name));
                System.out.println(Name + " is added in the database.");
            }
            else {
                for (int i = 0; i < dbPerson.size(); i++) {
                    if (Name.equals(dbPerson.getPersonID(i).getName())) {
                        System.out.println(Name + " already exists. Please enter another name.");
                        return;
                    } else
                        nameInDb = false;
                }
                if (!nameInDb) {
                    dbPerson.addPerson(new Person(Name));
                    System.out.println(Name + " is added in the database.");
                }
            }

        }
    }

    @Override
    public void setPersonForTicket(int id, double Amount, double Cost){
        dbPerson.getPersonID(id).setAmount(Amount);
        dbPerson.getPersonID(id).setCost(Cost);
    }
}
