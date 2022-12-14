
import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.RegistrationDbTicket;
import dbTicket.dbTicket;
import view.Menu.viewMenu;



public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main(){
    }

    public void run(){


        //Initialising databases and controllers (and view).
        dbPerson dbPerson = RegistrationdbPerson.getInstance();
        RegistrationControlPerson regPerson = new RegistrationControlPerson(dbPerson);

        dbTicket dbTicket = RegistrationDbTicket.getInstance();
        RegistrationControlTicket regTicket= new RegistrationControlTicket(dbTicket);

        // gui:
        viewMenu view = new viewMenu();
        view.initialize(regPerson, regTicket, dbPerson, dbTicket);







    }

}

