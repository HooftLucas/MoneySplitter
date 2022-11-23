package diffTicket;


// class voor de naam van het ticket.
// kan later nog verdeeld worden in verschillende soorten tickets adhv subclasses of factory
public class Ticket {
    public String ticket;

    public Ticket(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return ticket;
    }
}
