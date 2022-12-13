package Bill;

import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import dbTicket.dbTicket;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Calculate {

    private static dbTicket dbTicket = RegistrationDbTicket.getInstance();
    private static dbPerson dbPerson = RegistrationdbPerson.getInstance();
    private static HashMap<String , Double> BalanceMap = new HashMap<>();

    public static HashMap<String , Double> Balance() {

        for (int ticketI = 0; ticketI < dbTicket.size(); ticketI++) {
            TicketArray tempTA = dbTicket.getTicketID(ticketI);
            double moneyPaidTotal = 0, moneyPaid = 0, moneyOwedTotal = 0, moneyOwed = 0;
            int evenSize = dbPerson.size();
            String name;

            for (int personID = 0; personID < dbPerson.size(); personID++) {
                if (tempTA.getPerson(personID).getAmount() != 0.0) {
                    name = tempTA.getPerson(personID).getName();
                    moneyPaid = tempTA.getPerson(personID).getAmount();
                    moneyPaidTotal += moneyPaid;
                    BalanceMap.put(name,BalanceMap.getOrDefault(name,0.0) - moneyPaid);
                }
            }
            for (int personID = 0; personID < dbPerson.size(); personID++) { //person has to pay a set cost.
                name = tempTA.getPerson(personID).getName();
                if (tempTA.getPerson(personID).getCost() != 0.0){
                    evenSize = evenSize - 1;
                    moneyOwed = tempTA.getPerson(personID).getCost();
                    moneyOwedTotal += moneyOwed;
                    BalanceMap.put(name,BalanceMap.getOrDefault(name,0.0) + moneyOwed);
                }
            }
            for (int personID = 0; personID < dbPerson.size(); personID++) { //person has to pay a variable cost based on the amount paid.
                name = tempTA.getPerson(personID).getName();
                if (tempTA.getPerson(personID).getCost() == 0.0){
                        moneyOwed = (moneyPaidTotal - moneyOwedTotal) / evenSize;
                        moneyOwedTotal += moneyOwed;
                        BalanceMap.put(name, BalanceMap.getOrDefault(name, 0.0) + moneyOwed);
                }
            }

            if (moneyPaidTotal - moneyOwedTotal > 0.0){ //if there is any money owed left over, divide costs equally.
                for (int personID = 0; personID < dbPerson.size(); personID++) {
                    name = tempTA.getPerson(personID).getName();
                    moneyOwed = (moneyPaidTotal - moneyOwedTotal) / dbPerson.size();
                    BalanceMap.put(name, BalanceMap.getOrDefault(name, 0.0) + moneyOwed);
                }
            }

        }
        return BalanceMap;
    }








}
