package globalBillCalc;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.dbPerson;

import dbTicket.TicketArray;
import dbTicket.RegistrationDbTicket;

import java.util.ArrayList;
import java.util.Iterator;

public class Calculate {

    private RegistrationDbTicket dbT;

    public Calculate(RegistrationDbTicket ticket) {
        this.dbT = ticket;
    }



    public double Sum(){
        double calculated =0.0;
        double totalBill = 0.0;
        TicketArray Ticket;
        for(int i = 0; i < dbT.size(); i++){
            Ticket = dbT.getTicketID(i);
            System.out.println(i);

        }
        return calculated;
    }
}
