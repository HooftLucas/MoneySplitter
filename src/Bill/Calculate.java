package Bill;

import Person.Person;
import dbPerson.dbPerson;
import dbPerson.RegistrationdbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.dbTicket;
import dbTicket.TicketArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Calculate {

    private static dbTicket dbT = RegistrationDbTicket.getInstance();
    private static dbPerson dbP = RegistrationdbPerson.getInstance();
    private static HashMap<String , Double> sumMap = new HashMap<>();

    public static HashMap<String , Double> Sum() {
        double moneyPaid;
        double amountPaid;
        double costPaid;
        String name;

        for (int ticketI = 0; ticketI < dbT.size(); ticketI++) {
            TicketArray tempTA = dbT.getTicketID(ticketI);
            for (int personI = 0; personI <dbP.size();personI++) {
                Person tempP = tempTA.getPerson(personI);
                name = tempP.getName();
                amountPaid = tempP.getAmount();
                costPaid = tempP.getCost();

                // calc moneyPaid
                moneyPaid = amountPaid - costPaid; // temporary value, has to change in the future.
                sumMap.put(name,sumMap.getOrDefault(name, 0.0) + moneyPaid);
            }
            // at the end of each loop add the name + money paid in a HashMap:
            // sumMap.put(name,sumMap.getOrDefault(name, 0.0) + moneyPaid);
        }



        return sumMap;
    }




}
