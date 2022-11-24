package dbTicket;

import Person.Person;

import java.util.ArrayList;

public class RegistrationDbTicket extends dbTicket{

    private static RegistrationDbTicket instance;
    private final ArrayList<TicketArray> TicketList;
    public RegistrationDbTicket() {
        this.TicketList = new ArrayList<>();
    }

    // singleton:
    public static RegistrationDbTicket getInstance() {
        if(instance == null) {
            instance = new RegistrationDbTicket();
        }  return instance;
    }

    @Override
    public void addTicket(TicketArray ticket) {
        this.TicketList.add(ticket);
    }

    @Override
    public void deleteTicket(TicketArray ticket) {
        if(TicketList.contains(ticket)){
            TicketList.remove(ticket);
        }else {
            System.out.println(ticket.getTicket()+" is not in the database");
        }
    }

    @Override
    public int size() {
        return TicketList.size();
    }

    @Override
    public void printDatabase() {
        for (TicketArray ticketArray : TicketList) {
            System.out.println(ticketArray);
        }
    }

    @Override
    public TicketArray getTicketID(int id) {
        return null;
    }





}


