package view.Menu;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;
import view.Bill.ViewBill;
import view.Person.ViewPerson;
import view.Ticket.ViewTicket;
import view.error.ViewError;

import javax.swing.*;

public class RegistrationButtonPanel extends JPanel{
    private final JButton addPersonMenu;
    private final JButton addTicketMenu;
    private final JButton CalcBillMenu;
    private final RegistrationControlPerson controlPerson;
    private final RegistrationControlTicket controlTicket;

    private final ViewPerson viewPerson = new ViewPerson();
    private final ViewTicket viewTicket = new ViewTicket();

    private final ViewBill viewBill = new ViewBill();
    dbPerson dbPerson;
    dbTicket dbTicket;
    private final ViewError viewerror = new ViewError();

    public RegistrationButtonPanel(RegistrationControlPerson regPerson, RegistrationControlTicket regTicket, dbPerson dbPerson, dbTicket dbTicket){
        this.dbPerson = dbPerson;
        this.dbTicket= dbTicket;
        JLabel label = new JLabel("Split your bill");
        //Person
        this.addPersonMenu = new JButton("add new persons");
        this.controlPerson = regPerson;
        //Ticket
        this.addTicketMenu = new JButton("add new ticket");
        this.controlTicket = regTicket;
        //bill
        this.CalcBillMenu = new JButton("calculate bill" );

        addPersonActionListener();
        addTicketActionListener();
        CalcBillActionListener();
        this.setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
        this.add(label);
        this.add(this.addPersonMenu);
        this.add(this.addTicketMenu);
        this.add(this.CalcBillMenu);
    }
    public void addPersonActionListener(){
        this.addPersonMenu.addActionListener(listener -> {
            viewPerson.initialize(controlPerson, dbPerson);
        });
    }
    public void addTicketActionListener(){
        this.addTicketMenu.addActionListener(listener -> {
            if(dbPerson.size()>=2) {
                viewTicket.initialize(controlTicket, dbPerson, controlPerson, dbTicket);
            }else
                viewerror.initialize("Ticket", "people");
        });
    }
    public void CalcBillActionListener(){
        this.CalcBillMenu.addActionListener(listener -> {
            if(dbPerson.size()<2&& dbTicket.size()==0) {
                viewerror.initialize("bill", "Persons and tickets");
            }else if(dbPerson.size()>=2&&dbTicket.size() == 0) {
                viewerror.initialize("bill", "Tickets");
            }
            else {
                viewBill.initialize(dbPerson, dbTicket);

            }


        });
    }



}