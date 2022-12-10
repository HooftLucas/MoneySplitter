package controller.Ticket;

import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import dbTicket.dbTicket;
import diffTicket.Ticket;
import diffTicket.TicketFactory;


public class RegistrationControlTicket implements Controller {
    private dbTicket dbTicket;

    public RegistrationControlTicket(dbTicket dbTicket){
        this.dbTicket = dbTicket;
    }

    @Override
    public void addTicketEntry(String name,String function) {
        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        Ticket tempTicket = TicketFactory.getTicket(name,function);
        TicketArray tempTA = new TicketArray(tempTicket, dbPerson);
        dbTicket.addTicket(tempTA);
        System.out.println("Ticket is added: " + tempTA);
    }
}
