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

        // testing dbPerson methods:
        dbPerson testPer = RegistrationdbPerson.getInstance();
        RegistrationControlPerson reg = new RegistrationControlPerson(testPer);

        Person Alex = new Person("Alex",true,120,0);
        Person Bart = new Person("Bart",false,0,0);
        Person Cedric = new Person("Cedric",false,0,0);
        Person Dirk = new Person("Dirk",false,0,0);

        testPer.addPerson(Alex);
        testPer.addPerson(Bart);
        testPer.addPerson(Cedric);
        testPer.addPerson(Dirk);

        System.out.println(testPer.size());
        testPer.Loop();

        testPer.deletePerson(Bart);
        System.out.println(testPer.size());
        Person Lukas = new Person("Lukas",true,50,10);
        testPer.deletePerson(Lukas);
        System.out.println(testPer.size());
        testPer.Loop();



        // testing RegistrationControllor methods for dbPerson:
        Person Ella = new Person("Ella",false,0,0);
        Person empty = new Person("",false,0,0);

        reg.ConfirmName(Ella);
        reg.ConfirmName(empty);
        System.out.println(testPer.size());
        testPer.Loop();



        // testing dbTicket methods:





    }
}

