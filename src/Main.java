import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.TicketArray;
import dbTicket.dbTicket;
import dbTicket.RegistrationDbTicket;
import diffTicket.Ticket;
import controller.ticket.RegistrationControlTicket;

import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }
    public Main(){

    }
    public void run(){

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
        Ticket testTickName1 = new Ticket("Winkel");
        Ticket testTickName2 = new Ticket("Resto");
        regT.addTicketEntry(testTickName1);
        regT.addTicketEntry(testTickName2);
        testTicket.printDatabase();











    }

}

