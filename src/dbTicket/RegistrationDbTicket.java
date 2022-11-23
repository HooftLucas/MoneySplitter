package dbTicket;

import java.util.ArrayList;

public class RegistrationDbTicket extends dbTicket{

    private static RegistrationDbTicket regDB;
    private final ArrayList<TicketArray> db = new ArrayList<>();
    private RegistrationDbTicket() {}

// singleton:
    public static RegistrationDbTicket getInstance() {
        if(regDB == null) {
            regDB = new RegistrationDbTicket();
        }  return regDB;
    }

    @Override
    public void addEntry(TicketArray ticketArray) {
        db.add(ticketArray);
    }

}


