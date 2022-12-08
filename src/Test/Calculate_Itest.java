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
        RegistrationControlTicket regT = new RegistrationControlTicket(testDbT);
        regT.addTicketEntry("Theater","Culture");

    }

    @Test
    public void t_Calculate_Sum() {
        // testing the Sum method in Class calculate:

        HashMap<String, Double> compareMap = new HashMap<>();
        compareMap.put("Alex", 300.0);
        compareMap.put("Bart", 0.0);
        compareMap.put("Cedric", 0.0);
        compareMap.put("Dirk", 0.0);

        HashMap<String, Double> testMap = Calculate.Sum();

        assertEquals("Testing booking integration - day 10 - should return 0",
                compareMap, testMap);
    }

    /*
    @Test
    pulic void t_Calculate_exchange() {
        // testing the exchange methods in Class calculate:
    }

    */



}
