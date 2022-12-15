package dbTicket;


import Person.Person;

import java.util.Observable;

public abstract class dbTicket {

    public dbTicket(){}

    public void addTicket(TicketArray ticket) {}
    public abstract void deleteTicket(TicketArray ticket);
    public abstract int size();
    public abstract void printDatabase();
    public abstract TicketArray getTicketID(int id);







}
