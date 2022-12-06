package view.Ticket;

import Person.Person;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewTicket extends JFrame implements Observer {
    RegistrationControlTicket controlTicket;
    RegisterButton buttons;

    protected GridBagConstraints c = new GridBagConstraints();

    public ViewTicket(){super("give your ticket");}
    public void initialize(RegistrationControlTicket controlTicket, dbPerson db){
        this.controlTicket = controlTicket;
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        buttons = new RegisterButton(controlTicket, this, c, db);
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
