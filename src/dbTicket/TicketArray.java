package dbTicket;

import Person.Person;
import dbPerson.dbPerson;
import diffTicket.Ticket;
import java.util.ArrayList;


public class TicketArray {

    ArrayList<Object> array = new ArrayList<>();

    public TicketArray(Ticket ticket,dbPerson db) {
        this.array.add(ticket);
        for (int i = 0; i < db.size(); i++) {
            this.array.add(db.getPersonID(i));
        }
    }

    public Ticket getTicket() {
        return (Ticket) this.array.get(0);
    }

    public Person getPerson(int i) {
            return (Person) this.array.get(i + 1);
    }

    @Override
    public String toString() {
        return  array + "." ;
    }
}
