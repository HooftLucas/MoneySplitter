package controller.Ticket;

import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import dbTicket.dbTicket;
import diffTicket.Ticket;
import diffTicket.TicketFactory;


public class RegistrationControlTicket implements Controller {
    private final dbTicket dbTicket;

    public RegistrationControlTicket(dbTicket dbTicket){
        this.dbTicket = dbTicket;
    }

    @Override
    public void addTicketEntry(String name,String function) {
        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        Ticket tempTicket = TicketFactory.getTicket(name,function);
        TicketArray tempTA = new TicketArray(tempTicket, dbPerson);

        // check if amount paid > cost to pay:
        double totalAmount = 0,totalCost = 0;
        for (int personID = 0; personID < dbPerson.size(); personID++) {
                totalAmount += tempTA.getPerson(personID).getAmount();
                totalCost += tempTA.getPerson(personID).getCost();
        }
        
        if (totalAmount < totalCost){
            System.out.println("Invalid Ticket: total cost to pay is higher then total amount paid!");
        }
        else {
            dbTicket.addTicket(tempTA);
            System.out.println("Ticket is added: " + tempTA);
            //dbTicket.printDatabase();
        }
    }
}
