package dbPerson;

import Person.Person;

import java.util.ArrayList;
import java.util.List;
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
    public void Loop() {
        Iterator<Person> it = PersonList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
