package view.Menu;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;

public class viewMenu extends JFrame {
    private RegistrationControlPerson regPerson;

    RegistrationButtonPanel buttons;
    public viewMenu(){
        super("Menu");
    }
    public void initialize(RegistrationControlPerson regPerson, RegistrationControlTicket regTicket, dbPerson dbPerson, dbTicket dbTicket){
        this.setSize(700,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistrationButtonPanel(regPerson, regTicket, dbPerson, dbTicket);

        this.add(buttons);
        this.setVisible(true);
    }


}