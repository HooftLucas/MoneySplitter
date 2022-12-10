package diffTicket;

import java.util.Objects;

public class TicketFactory {


    public static Ticket getTicket(String Name, String function){
        if (Objects.equals(function, "Culture")){
            return new Culture(Name);
        }
        else if(Objects.equals(function, "Food")){
            return new Food(Name);
        }
        else if(Objects.equals(function, "Transport")){
            return new Transport(Name);
        }
        else return new Ticket(Name,"Other");
    }

}
