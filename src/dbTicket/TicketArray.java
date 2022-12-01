package dbTicket;

import dbPerson.dbPerson;
import diffTicket.Ticket;
import java.util.ArrayList;


public class TicketArray {

    ArrayList<ArrayList<Object>> array = new ArrayList<>();
    RegistrationDbTicket Reg = new RegistrationDbTicket();

    public TicketArray(Ticket ticket,dbPerson db) {
        this.array.add(new ArrayList<>());
        this.array.get(0).add(ticket);
        for (int i = 0; i < db.size(); i++) {
            this.array.add(new ArrayList<>());
            this.array.get(i+1).add(db.getPersonID(i));
        }

    }


    public Ticket getTicket(int id) {
        return (Ticket) this.array.get(id).get(id);
    }

    @Override
    public String toString() {
        return  array + "." ;
    }


}
