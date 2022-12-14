package Test;

import Person.Person;
import controller.Person.RegistrationControlPerson;
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

public class Calculate_ITest {

    @Before
    public void initialize() {
    }

    @Test
    public void t_Calculate_Balance() {
        // testing the Balance method in Class calculate:

        //Init:
        System.out.println("Testing the Balance Method:");
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        dbTicket testDbT = RegistrationDbTicket.getInstance();
        RegistrationControlPerson regPerson = new RegistrationControlPerson(testDbP);
        RegistrationControlTicket regTicket = new RegistrationControlTicket(testDbT);
        HashMap<String, Double> compareMap = new HashMap<>();
        HashMap<String, Double> testMap;

        Person A = new Person("A",200,0);
        testDbP.addPerson(A);
        Person B = new Person("B");
        testDbP.addPerson(B);
        Person C = new Person("C");
        testDbP.addPerson(C);
        Person D = new Person("D");
        testDbP.addPerson(D);


        //Case1
        System.out.println("Case1 : Bill is split evenly.");
        regTicket.addTicketEntry("Case1","");
        compareMap.put("A", -150.0);
        compareMap.put("B", 50.0);
        compareMap.put("C", 50.0);
        compareMap.put("D", 50.0);
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 1' : ",
                compareMap, testMap);
        testMap.clear();
        System.out.println("------------------------------------------------");

        //Case2
        System.out.println("Case2 : Bill is split unevenly.");
        A.setCost(20);B.setCost(80);C.setCost(70);D.setCost(30);
        regTicket.addTicketEntry("Case2","");
        compareMap.put("A", -330.0);
        compareMap.put("B", 130.0);
        compareMap.put("C", 120.0);
        compareMap.put("D", 80.0);
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 2' : ",
                compareMap, testMap);
        testMap.clear();
        System.out.println("------------------------------------------------");

        //Case3
        System.out.println("Case3 : Bill is split uneven for some and even for others.");
        A.setCost(0.0);B.setCost(0.0);
        regTicket.addTicketEntry("Case3","");
        compareMap.put("A", -480.0);
        compareMap.put("B", 180.0);
        compareMap.put("C", 190.0);
        compareMap.put("D", 110.0);
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 3' : ",
                compareMap, testMap);
        testMap.clear();
        System.out.println("------------------------------------------------");

        //Case4
        System.out.println("Case1 : Bill is paid by multiple people.");
        A.setAmount(100);B.setAmount(100);C.setCost(0);D.setCost(0);
        regTicket.addTicketEntry("Case2","");
        compareMap.put("A", -530.0);
        compareMap.put("B", 130.0);
        compareMap.put("C", 240.0);
        compareMap.put("D", 160.0);
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 4' : ",
                compareMap, testMap);
        testMap.clear();
        System.out.println("------------------------------------------------");

        //Case5
        System.out.println("Case5 : Amount paid > costs => leftover is split evenly.");
        A.setAmount(200);A.setCost(30);B.setAmount(0);B.setCost(20);C.setCost(10);D.setCost(40);
        regTicket.addTicketEntry("Case5","");
        compareMap.put("A", -675.0);
        compareMap.put("B", 175.0);
        compareMap.put("C", 275.0);
        compareMap.put("D", 225.0);
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 5' : ",
                compareMap, testMap);
        testMap.clear();
        System.out.println("------------------------------------------------");

        //Case6
        System.out.println("Case6 : Amount paid < costs => invalid ticket.");
        A.setAmount(50);A.setCost(20);B.setCost(80);C.setCost(70);D.setCost(30);
        regTicket.addTicketEntry("Case6","");
        testMap = Calculate.Balance();
        assertEquals("Testing 'Case 6' : ",
                compareMap, testMap);
        System.out.println("------------------------------------------------");
    }
}
