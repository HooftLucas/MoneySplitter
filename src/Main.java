import Person.Person;
import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.dbTicket;
import dbTicket.RegistrationDbTicket;
import view.Menu.viewMenu;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
       // menuWindow menu = new menuWindow();
       // menu.menuWindow();
       // run(menu);

    }

    public static void run(){

        // testing dbPerson methods:
        System.out.println("Testing the dbPerson methods:");
        dbPerson testPer = RegistrationdbPerson.getInstance();
        RegistrationControlPerson regP = new RegistrationControlPerson(testPer);

        Person Alex = new Person("Alex",120,0);
        Person Bart = new Person("Bart",0,0);
        Person Cedric = new Person("Cedric",0,0);
        Person Dirk = new Person("Dirk",0,0);

        testPer.addPerson(Alex);
        testPer.addPerson(Bart);
        testPer.addPerson(Cedric);
        testPer.addPerson(Dirk);

        System.out.println(testPer.size());
        testPer.printDatabase();

        testPer.deletePerson(Bart);
        System.out.println(testPer.size());
        Person Lukas = new Person("Lukas",50,10);
        testPer.deletePerson(Lukas);
        System.out.println(testPer.size());
        testPer.printDatabase();



        // testing RegistrationControllor methods for dbPerson:
        Person Ella = new Person("Ella",0,0);
        Person empty = new Person("",0,0);

        regP.ConfirmName("Ella");
        regP.ConfirmName("");
        System.out.println(testPer.size());
        testPer.printDatabase();





        // testing dbTicket methods:
        System.out.println('\n' + "Testing the methods for dbTicket:");
        dbTicket testTicket = RegistrationDbTicket.getInstance();
        RegistrationControlTicket regT = new RegistrationControlTicket(testTicket);
        regT.addTicketEntry("Theater","Culture");
        regT.addTicketEntry("Resto","Food");
        testTicket.printDatabase();
        // test gui
        //RegistrationControlPerson regPerson = new RegistrationControlPerson(testPer);

        viewMenu view = new viewMenu();
        view.initialize(regP, regT,testPer,testTicket );










    }

}

