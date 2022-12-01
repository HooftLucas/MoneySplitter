package diffTicket;

public class TicketFactory {


    public static Ticket getTicket(String Name, String function){
        if (function == "Culture"){
            return new Culture(Name);
        }
        else if(function == "Food"){
            return new Food(Name);
        }
        else if(function == "Transport"){
            return new Transport(Name);
        }
        else return new Ticket(Name,"Other");
    }

}
