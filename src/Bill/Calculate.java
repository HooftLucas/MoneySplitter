package Bill;

import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import dbTicket.dbTicket;

import java.util.HashMap;

public class Calculate {

    private static dbTicket dbTicket = RegistrationDbTicket.getInstance();
    private static dbPerson dbPerson = RegistrationdbPerson.getInstance();
    private static HashMap<String , Double> BalanceMap = new HashMap<>();

    public static HashMap<String , Double> Balance() {
        double moneyPaid = 0;
        double moneyOwed = 0;
        String name;
        boolean even = false;


        for (int ticketI = 0; ticketI < dbTicket.size(); ticketI++) {
            TicketArray tempTA = dbTicket.getTicketID(ticketI);

            for (int personID = 0; personID < dbPerson.size(); personID++) {
                if (tempTA.getPerson(personID).getAmount() != 0.0) { // gives the person who paid.
                    name = tempTA.getPerson(personID).getName();
                    moneyPaid = tempTA.getPerson(personID).getAmount();
                    BalanceMap.put(name,BalanceMap.getOrDefault(name,0.0) - moneyPaid);
                }
            }
            for (int personID = 0; personID < dbPerson.size(); personID++) {
                name = tempTA.getPerson(personID).getName();
                if (tempTA.getPerson(personID).getCost() == 0.0){ //even
                    moneyOwed = moneyPaid / dbPerson.size();
                }
                else { //uneven
                    moneyOwed = tempTA.getPerson(personID).getCost();
                }
                BalanceMap.put(name, BalanceMap.getOrDefault(name, 0.0) + moneyOwed);
            }

        }
        return BalanceMap;
    }






}
