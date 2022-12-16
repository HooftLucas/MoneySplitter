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
    public void addNameToDatabase(String name) {
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        boolean nameInDb = true;

        if(name.isEmpty()){
            System.out.println("The given name is empty.");
        }
        else {
            if(dbPerson.size() == 0) {
                dbPerson.addPerson(new Person(name));
                System.out.println(name + " is added in the database.");
            }
            else {
                for (int i = 0; i < dbPerson.size(); i++) {
                    if (name.equals(dbPerson.getPersonID(i).getName())) {
                        System.out.println(name + " already exists. Please enter another name.");
                        return;
                    } else
                        nameInDb = false;
                }
                if (!nameInDb) {
                    dbPerson.addPerson(new Person(name));
                    System.out.println(name + " is added in the database.");
                }
            }

        }
    }

    @Override
    public void deleteNameFromDatabase(String name) {
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        boolean nameInDb = false;

        if(name.isEmpty()){
            System.out.println("The given name is empty.");
        }
        else {
            for (int i = 0; i < dbPerson.size(); i++) {
                if (name.equals(dbPerson.getPersonID(i).getName())) {
                    dbPerson.deletePerson(dbPerson.getPersonID(i));
                    System.out.println(name + " is removed from the database.");
                    nameInDb = true;
                }
            }
            if(!nameInDb){
                System.out.println(name + " is not in the database.");
            }
        }
    }

    @Override
    public void setPersonForTicket(int id, double amount, double cost,boolean participate ){
        dbPerson.getPersonID(id).setAmount(amount);
        dbPerson.getPersonID(id).setCost(cost);
        dbPerson.getPersonID(id).setParticipate(participate);
    }
}
