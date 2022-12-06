package view.Bill;

import Person.Person;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.RegistrationdbPerson;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewBill extends JFrame implements Observer {
    RegistationButton buttons;
    protected GridBagConstraints c = new GridBagConstraints();
    RegistrationControlTicket controlTicket;
    public ViewBill(){super("give the total bill");}
    public void initialize(RegistrationControlTicket regControl, dbPerson db, dbTicket dbT){
        this.controlTicket = regControl;
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistationButton(controlTicket, this, c, db, dbT);
        this.add(buttons);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {


    }
}
