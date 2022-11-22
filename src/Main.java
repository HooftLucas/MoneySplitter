import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }
    public Main(){

    }
    public void run(){

        // test voor database person:
        dbPerson testPer = RegistrationdbPerson.getInstance();
        RegistrationControlPerson reg = new RegistrationControlPerson(testPer);
        testPer.addPerson("Alex");
        testPer.addPerson("Bart");
        testPer.addPerson("Cedric");
        testPer.deletePerson("bart");
        testPer.deletePerson("Lukas");
        reg.ConfirmName("Ann");
        reg.ConfirmName("");
        testPer.deletePerson("Ann");

        System.out.println(testPer.size()); //toont grootte van dbPerson
        testPer.Loop(); // geeft alle entry's in dbPerson



        // test voor database ticket:
        Person p1 = new Person("Alex",true,90,0);
        Person p2 = new Person("Bart",false,0,0);
        Person p3 = new Person("Cedric",false,0,0);




    }
}

