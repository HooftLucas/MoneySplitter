package dbPerson;

import Person.Person;
import java.util.ArrayList;
import java.util.Iterator;

public class RegistrationdbPerson extends dbPerson{

    private static RegistrationdbPerson instance;
    private final ArrayList<Person> PersonList;
    public RegistrationdbPerson() {
        this.PersonList = new ArrayList<>();
    }
    int teller = 0;
    // singleton:
    public static RegistrationdbPerson getInstance() {
        if(instance == null) {
            instance = new RegistrationdbPerson();
        }  return instance;
    }

    @Override
    public void addPerson(Person person) {
        this.PersonList.add(person);
    }

    @Override
    public void deletePerson(Person person) {
        if(PersonList.contains(person) | !PersonList.isEmpty()){
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

    @Override
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
    public String getName(int id){
        Person person = PersonList.get(id);
        return person.getName();
    }

    @Override
    public boolean checkDb(Person person) {
        for(int i = 0; i< size(); i++){
            if(person.getName() == getName(i))
                return true;
        }

        return false;
    }


}
