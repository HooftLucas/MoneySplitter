package dbTicket;

import java.util.ArrayList;
import java.util.Iterator;

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
    public void addTicket(TicketArray ticketarray) {
        this.TicketList.add(ticketarray);
    }

    @Override
    public void deleteTicket(TicketArray ticketarray) {
        if(TicketList.contains(ticketarray)){
            TicketList.remove(ticketarray);
        }else {
            System.out.println(ticketarray+" is not in the database");
        }
    }

    @Override
    public int size() {
        return TicketList.size();
    }

    @Override
    public void printDatabase() {
        System.out.println("Ticket database Content:");
        for (TicketArray ticketArray : TicketList) {
            System.out.println(ticketArray);
        }
    }

    @Override
    public TicketArray getTicketID(int id) {
        Iterator<TicketArray> it = TicketList.iterator();
        for (int i = 0; i < id; i++) {
            it.next();
        }
        if (it.hasNext()) {
            return it.next();
        } else {
            System.out.println("Error: Out of bounds of Database.");
            return null;
        }
    }


}


