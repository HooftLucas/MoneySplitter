package dbPerson;

import java.util.ArrayList;
import java.util.List;

public class RegistrationdbPerson extends dbPerson{
    private ArrayList<String> NameList;
    private static RegistrationdbPerson instance;
    public RegistrationdbPerson() {
        this.NameList = new ArrayList<>();
    }

    //singelton
    public static RegistrationdbPerson getInstance(){
        if(instance == null){
            instance = new RegistrationdbPerson();
        }
        return instance;
    }


    @Override
    public void addPerson(String name) {
        this.NameList.add(name);
        instance.setChanged();
        instance.notifyObservers(name);
        System.out.println(name);


    }

    @Override
    public void deletePerson(String name) {
        if(NameList.contains(name)){
            NameList.remove(name);

        }else {
            System.out.println(name+" is not in the database");
        }
    }
}
