
import Bill.Calculate;
import Person.Person;
import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.dbTicket;
import view.Menu.viewMenu;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main(){
    }

    public void run(){


        //Initialising databases and controllers (and view).
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        RegistrationControlPerson regPerson = new RegistrationControlPerson(dbPerson);

        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        RegistrationControlTicket regTicket= new RegistrationControlTicket(dbTicket);


        // gui:
        viewMenu view = new viewMenu();
        view.initialize(regPerson, regTicket, dbPerson, dbTicket);


        // testing:
        /*
        Person a = new Person("a",100.0,0.0,true);
        Person b = new Person("b",0.0,0.0,true);
        Person c = new Person("c",0.0,0.0,true);
        dbPerson.addPerson(a);
        dbPerson.addPerson(b);
        dbPerson.addPerson(c);
        regTicket.addTicketEntry("test","");
        HashMap<String, Double> testMap = Calculate.Balance();
        System.out.println(testMap);
        a.setAmount(0.0);b.setAmount(100.0);c.setParticipate(false);
        regTicket.addTicketEntry("t2","");
        testMap = Calculate.Balance();
        System.out.println(testMap);
        System.out.println(Calculate.Exchange(testMap));

         */













    }

}

