package dbPerson;

import Person.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistrationdbPerson extends dbPerson{
    private final ArrayList<Person> PersonList;
    private static RegistrationdbPerson instance;
    public RegistrationdbPerson() {
        this.PersonList = new ArrayList<>();
    }

    //singleton
    public static RegistrationdbPerson getInstance(){
        if(instance == null){
            instance = new RegistrationdbPerson();
        }
        return instance;
    }


    @Override
    public void addPerson(Person person) {
        this.PersonList.add(person);
        instance.setChanged();
        instance.notifyObservers(person);
        System.out.println(person);
    }


    @Override
    public void deletePerson(Person person) {
        if(PersonList.contains(person)){
            PersonList.remove(person);
        }else {
            System.out.println(person.getName()+" is not in the database");
        }
    }

    @Override
    public int size() {
        return PersonList.size();
    }

    @Override
    public void printDatabase() {
        for (Person person : PersonList) {
            System.out.println(person);
        }
    }

    public Person getPersonID(int id) { //int id is locatie in database.
        Iterator<Person> it = PersonList.iterator();
            for (int i = 0; i < id; i++) {
                it.next();
            }
            if (it.hasNext()) {
                return it.next();
            } else {
                System.out.println("Error: Out of bounds of Database.");
                return null;
            }
    }



    @Override
    public ArrayList<Person> GiveDB() {
        return PersonList;
    }


}
