package view.Menu;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import view.Person.PersonPanel;
import view.Person.ViewPerson;
import view.Ticket.ViewTicket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationButtonPanel extends JPanel implements ActionListener {
    private final JButton addPerson;
    private final JButton addTicket;
    private final JButton CalcBill;
    private final RegistrationControlPerson controlPerson;
    private final RegistrationControlTicket controlTicket;

    private final ViewPerson viewPerson = new ViewPerson();
    private final ViewTicket viewTicket = new ViewTicket();
    private dbPerson db;

    public RegistrationButtonPanel(RegistrationControlPerson regPer, RegistrationControlTicket regTicket, dbPerson db){
        this.db = db;
        JLabel label = new JLabel("Split your bills");
        //Person
        this.addPerson = new JButton("add persons");
        this.controlPerson = regPer;
        //Ticket
        this.addTicket = new JButton("add Ticket");
        this.controlTicket = regTicket;
        //bill
        this.CalcBill = new JButton("calculate the total bill" );


        addPersonActionListener();
        addTicketActionListener();
        CalcBillActionListener();
        this.setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
        this.add(label);
        this.add(this.addPerson);
        this.add(this.addTicket);
        this.add(this.CalcBill);
    }
    public void addPersonActionListener(){
        this.addPerson.addActionListener(listener -> {
            //controlPerson.ConfirmName("Bob");
            viewPerson.initialize(controlPerson);
        });
    }
    public void addTicketActionListener(){
        this.addTicket.addActionListener(listener -> {
            //controlTicket.addTicketEntry("resto", "MCDO");
            viewTicket.initialize(controlTicket, db);
        });
    }
    public void CalcBillActionListener(){
        this.CalcBill.addActionListener(listener -> {
            System.out.println(" calculate the bill");
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        String nameEmployee;
        if(s.equals("submit")){
            nameEmployee = s;

        }

    }


}