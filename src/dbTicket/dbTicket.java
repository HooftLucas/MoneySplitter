package dbTicket;

import Person.Person;
import diffTicket.Ticket;

public abstract class dbTicket {

    public dbTicket(){}

    public abstract void addEntry(TicketArray ticket);

    public abstract TicketArray getEntry(int id);


}
