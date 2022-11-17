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
        dbPerson testPer = RegistrationdbPerson.getInstance();
        RegistrationControlPerson reg = new RegistrationControlPerson(testPer);
        testPer.addPerson("bob");
        testPer.addPerson("Bas");
        testPer.deletePerson("bob");
        testPer.deletePerson("Lukas");

    }
}

