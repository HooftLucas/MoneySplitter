package view.Menu;



import Person.Person;
import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class viewMenu extends JFrame implements Observer {
    private RegistrationControlPerson regPerson;
    ListPanel panel;
    RegistrationButtonPanel buttons;
    public viewMenu(){
        super("Menu");
    }
    public void initialize(RegistrationControlPerson regPerson, RegistrationControlTicket regTicket, dbPerson db){
        this.setSize(700,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistrationButtonPanel(regPerson, regTicket, db);
        panel = new ListPanel();

        this.add(panel);
        this.add(buttons);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Person p= (Person) arg;
        String name = p.getName();
        RegistrationdbPerson rPerson = RegistrationdbPerson.getInstance();

    }
}