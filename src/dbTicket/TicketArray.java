package dbTicket;

import Person.Person;
import dbPerson.dbPerson;
import diffTicket.Ticket;
import java.util.ArrayList;


public class TicketArray {

    ArrayList<Object> array = new ArrayList<>();

    public TicketArray(Ticket ticket,dbPerson dbPerson) {
        this.array.add(ticket);
        for (int i = 0; i < dbPerson.size(); i++) {
            Person tempPerson = new Person(dbPerson.getPersonID(i));
            this.array.add(tempPerson);
        }
    }

    public Ticket getTicket() {
        return (Ticket) this.array.get(0);
    }

    public Person getPerson(int i) {
            return (Person) this.array.get(i + 1);
    }

    public int size() {
        return this.array.size();
    }

    @Override
    public String toString() {
        return  array + "." ;
    }

}
