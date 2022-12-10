package Test;

import Person.Person;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.dbTicket;
import dbTicket.RegistrationDbTicket;
import Bill.Calculate;

import java.util.HashMap;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Calculate_Itest {

    public Calculate_Itest() {
    }

    @Before
    public void initialize() {
        dbPerson testDbP = RegistrationdbPerson.getInstance();

        testDbP.addPerson(new Person("Alex",300.0,0.0));
        testDbP.addPerson(new Person("Bart"));
        testDbP.addPerson(new Person("Cedric"));
        testDbP.addPerson(new Person("Dirk"));

        dbTicket testDbT = RegistrationDbTicket.getInstance();
        RegistrationControlTicket regTicket = new RegistrationControlTicket(testDbT);
        regTicket.addTicketEntry("Theater","Culture");
        regTicket.addTicketEntry("macD","Food");

    }

    @Test
    public void t_Calculate_Balance() {
        // testing the Balance method in Class calculate:

        HashMap<String, Double> compareMap = new HashMap<>();
        compareMap.put("Alex", 150.0);
        compareMap.put("Bart", 150.0);
        compareMap.put("Cedric", 150.0);
        compareMap.put("Dirk", 150.0);


        HashMap<String, Double> testMap = Calculate.Balance();

        assertEquals("Testing the Balance of the bill:",
                compareMap, testMap);
    }

    /*
    @Test
    pulic void t_Calculate_exchange() {
        // testing the exchange methods in Class calculate:
    }

    */



}
