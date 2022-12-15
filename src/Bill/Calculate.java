package Bill;

import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.TicketArray;
import dbTicket.dbTicket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculate {

    private static final dbTicket dbTicket = RegistrationDbTicket.getInstance();
    private static final dbPerson dbPerson = RegistrationdbPerson.getInstance();
    private static final HashMap<String , Double> BalanceMap = new HashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static HashMap<String, Double> Balance() {
        BalanceMap.clear();
        for (int ticketI = 0; ticketI < dbTicket.size(); ticketI++) {
            TicketArray tempTA = dbTicket.getTicketID(ticketI);
            int personSize = tempTA.size() - 1; // allows persons to be added and deleted.
            double moneyPaidTotal = 0, moneyPaid, moneyOwedTotal = 0, moneyOwed, tempValue;
            int evenSize = personSize;
            String name;


            for (int personID = 0; personID < personSize; personID++) {
                if (tempTA.getPerson(personID).getAmount() != 0.0 & tempTA.getPerson(personID).isDoPay()) {
                    name = tempTA.getPerson(personID).getName();
                    moneyPaid = tempTA.getPerson(personID).getAmount();
                    moneyPaidTotal += moneyPaid;
                    BalanceMap.put(name,BalanceMap.getOrDefault(name,0.0) - moneyPaid);
                }
            }
            for (int personID = 0; personID < personSize; personID++) { //person has to pay a set cost.
                if (tempTA.getPerson(personID).getCost() != 0.0 & tempTA.getPerson(personID).isDoPay()){
                    name = tempTA.getPerson(personID).getName();
                    evenSize = evenSize - 1;
                    moneyOwed = tempTA.getPerson(personID).getCost();
                    moneyOwedTotal += moneyOwed;
                    BalanceMap.put(name,BalanceMap.getOrDefault(name,0.0) + moneyOwed);
                }
            } tempValue = moneyOwedTotal;

            for (int personID = 0; personID < personSize; personID++) { //person has to pay a variable cost based on the amount paid.
                if (tempTA.getPerson(personID).getCost() == 0.0 & tempTA.getPerson(personID).isDoPay()){
                    name = tempTA.getPerson(personID).getName();
                    moneyOwed = (moneyPaidTotal - moneyOwedTotal) / evenSize;
                    tempValue += moneyOwed;
                    BalanceMap.put(name, BalanceMap.getOrDefault(name, 0.0) + moneyOwed);
                }
            } moneyOwedTotal = tempValue;

            if (moneyPaidTotal - moneyOwedTotal > 0.0){ //if there is any money owed left over, divide costs equally.
                for (int personID = 0; personID < personSize; personID++) {
                    if(tempTA.getPerson(personID).isDoPay()) {
                        name = tempTA.getPerson(personID).getName();
                        moneyOwed = (moneyPaidTotal - moneyOwedTotal) / dbPerson.size();
                        BalanceMap.put(name, BalanceMap.getOrDefault(name, 0.0) + moneyOwed);
                    }
                }
            }

        }

        return BalanceMap;
    }

    // Exchange function calculates the exchange needed to settle bill.
    public static ArrayList<String> Exchange(HashMap<String, Double> BalanceMap) {
        // first make a deep copy of the BalanceMap:
        HashMap<String, Double> ExchangeMap = new HashMap<>();
        for (String i : BalanceMap.keySet()){
            ExchangeMap.put(i,BalanceMap.get(i));
        }

        // Calculate the exchange between persons:
        ArrayList<String> ExchangeOutput = new ArrayList<>();
        String posName = null;
        String negName = null;
        int zeroBalance = 0;
        double ErrorMargin = 0.005;
        while(zeroBalance < ExchangeMap.size()) {
            zeroBalance = 0;
            double posValue = 0;
            for (String key : ExchangeMap.keySet()) {
                if (Math.abs(ExchangeMap.get(key) - 0.0) <= ErrorMargin) {
                    zeroBalance ++;
                }
                else if(ExchangeMap.get(key) > 0.0){
                    posName = key;
                    posValue = ExchangeMap.get(key);
                }
                else if(ExchangeMap.get(key) < 0.0){
                    negName = key;
                }
            }
            if (zeroBalance != ExchangeMap.size() ) {
                ExchangeMap.replace(posName, ExchangeMap.getOrDefault(posName, 0.0) - posValue);
                ExchangeMap.replace(negName, ExchangeMap.getOrDefault(negName, 0.0) + posValue);
                ExchangeOutput.add(posName + " has to pay " + df.format(posValue) + " euros to " + negName);
            }
        }
        return ExchangeOutput;
    }


}
