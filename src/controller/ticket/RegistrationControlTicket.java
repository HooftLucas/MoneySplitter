package controller.ticket;

import dbPerson.dbPerson;
import dbPerson.RegistrationdbPerson;
import dbTicket.dbTicket;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import diffTicket.Ticket;
import diffTicket.TicketFactory;

public class RegistrationControlTicket implements Controller {
    private dbTicket db;
    public RegistrationControlTicket(dbTicket db){
        this.db = db;
    }


    @Override
    public void addTicketEntry(String name,String function) {
        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        Ticket tempTicket = TicketFactory.getTicket(name,function);
        TicketArray tempTA = new TicketArray(tempTicket, dbPerson);
        dbTicket.addTicket(tempTA);
    }
}
