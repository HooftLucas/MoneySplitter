package controller.ticket;

import dbPerson.dbPerson;
import dbPerson.RegistrationdbPerson;
import dbTicket.dbTicket;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import diffTicket.Ticket;

public class RegistrationControlTicket implements Controller {
    private dbTicket db;
    public RegistrationControlTicket(dbTicket db){
        this.db = db;
    }


    @Override
    public void addTicketEntry(Ticket ticket) {
        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        TicketArray temp = new TicketArray(ticket, dbPerson);
        dbTicket.addTicket(temp);
    }
}
