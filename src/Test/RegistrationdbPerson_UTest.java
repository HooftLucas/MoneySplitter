package Test;

import Person.Person;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RegistrationdbPerson_UTest {

    public RegistrationdbPerson_UTest()
    {

    }

    @Before
    public void initialize()
    {
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        testDbP.clear();
        Person testA = new Person("testA");
        Person testB = new Person("testB");
        testDbP.addPerson(testA);
        testDbP.addPerson(testB);
    }

    @Test
    public void t_size() {
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        assertEquals("Testing size - should be 2", 2, testDbP.size());
    }

    @Test
    public void t_addPerson(){
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        Person testC = new Person("testC");
        testDbP.addPerson(testC);
        assertEquals("Testing addPerson - should be =3", 3, testDbP.size() );

    }

    @Test
    public void t_delPerson(){
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        Person testC = new Person("testC");
        testDbP.addPerson(testC);
        assertEquals("Testing deletePerson - should be 3", 3, testDbP.size() );
        testDbP.deletePerson(testC);
        assertEquals("testing deletePerson - should be 2",2, testDbP.size() );
    }

    @Test
    public void t_clear(){
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        testDbP.clear();
        assertEquals("Testing clear - should be 0", 0, testDbP.size() );
    }

    @Test
    public void t_getPersonID(){
        dbPerson testDbP = RegistrationdbPerson.getInstance();
        Person testC = new Person("testC");
        testDbP.addPerson(testC);
        assertEquals("Testing getPersonID, should be testC", testC, testDbP.getPersonID(2) );
    }

}

