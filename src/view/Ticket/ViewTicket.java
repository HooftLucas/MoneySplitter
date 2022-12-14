package view.Ticket;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;

public class ViewTicket extends JFrame {
    RegistrationControlTicket controlTicket;
    RegisterButton buttons;
    RegistrationControlPerson controlPerson;
    dbTicket dbTicket;
    protected GridBagConstraints c = new GridBagConstraints();

    public ViewTicket(){super("give your ticket");}
    public void initialize(RegistrationControlTicket controlTicket, dbPerson dbPerson, RegistrationControlPerson controlPerson, dbTicket dbTicket){
        this.dbTicket = dbTicket;
        this.controlPerson = controlPerson;
        this.controlTicket = controlTicket;
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        buttons = new RegisterButton(controlTicket, this, c, dbPerson, controlPerson, dbTicket);
        this.add(buttons);
        this.setVisible(true);

    }




}
