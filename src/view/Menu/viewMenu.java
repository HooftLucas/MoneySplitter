package view.Menu;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class viewMenu extends JFrame {
    private RegistrationControlPerson regPerson;

    RegistrationButtonPanel buttons;
    public viewMenu(){
        super("Menu");
    }
    public void initialize(RegistrationControlPerson regPerson, RegistrationControlTicket regTicket, dbPerson db, dbTicket dbT){
        this.setSize(700,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistrationButtonPanel(regPerson, regTicket, db, dbT);

        this.add(buttons);
        this.setVisible(true);
    }


}