package dbTicket;

import diffTicket.Ticket;

import java.util.ArrayList;
import java.util.Observable;

public abstract class dbTicket extends Observable {

    public dbTicket(){}

    public void addTicket(TicketArray ticket) {
    }

    public abstract void deleteTicket(TicketArray ticket);

    public abstract int size();

    public abstract void printDatabase();

    public abstract TicketArray getTicketID(int id);







}
