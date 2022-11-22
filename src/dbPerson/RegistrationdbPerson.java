package dbPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class RegistrationdbPerson extends dbPerson{
    private ArrayList<String> NameList;
    private static RegistrationdbPerson instance;
    public RegistrationdbPerson() {
        this.NameList = new ArrayList<>();
    }

    //singleton
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

    @Override
    public int size() {
        return NameList.size();
    }

    @Override
    public void Loop() {
        Iterator<String> it = NameList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
