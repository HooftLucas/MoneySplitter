package view.Ticket;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterButton extends JPanel {
   // private ArrayList<JTextField> Amount;
    private JTextField[] Amount = new JTextField[1000] ;
    private JTextField[] Cost = new JTextField[1000] ;

    private JTextField titleTicket;
    private JButton AddTicket;
    private JButton Return;
    private JLabel tittle;

    private JLabel[] Name = new JLabel[100] ;

    private JLabel tittle_amount;
    private JLabel tittle_paid;

    private JLabel name_Ticket;

    private JLabel rules1;
    private JLabel rules2;
    private String[] Tickets = {"Culture", "Food", "Transport"};

    JList<String> list = new JList<>(Tickets);

    protected GridBagConstraints c = new GridBagConstraints();

    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    RegistrationControlTicket controlTicket;
    JList<String> dbJList = new JList<>(dbListModel);
    dbPerson db;
    RegistrationControlPerson controlPerson;
    dbTicket dbTicket;
    RegisterButton(RegistrationControlTicket controlTicket, JFrame close, GridBagConstraints c, dbPerson db, RegistrationControlPerson controlPerson, dbTicket dbTicket){
        this.controlPerson = controlPerson;
        this.dbTicket = dbTicket;
        this.c =c;
        this.db = db;
        this.controlTicket = controlTicket;
        tittle = new JLabel("Add your ticket");
        AddTicket = new JButton("add Ticket");
        Return = new JButton("Return");
        tittle_amount = new JLabel("who have paid");
        tittle_paid = new JLabel("total bill");
        rules1 = new JLabel("for an even split put a 0 by 'who have paid'");
        rules2 = new JLabel(" for not even split put the right value by 'who have paid'");
        titleTicket = new JTextField(10);
        name_Ticket = new JLabel("give the name of your ticket");


        AddTicketListener();
        ReturnMenuListener(close);

        this.add(dbJList);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());

        this.add(tittle,c );
        c.gridy++;
        c.gridx = 0;
        this.add(name_Ticket, c);
        c.gridx +=2;
        this.add(titleTicket, c);
        c.gridx ++;
        this.add(list, c);
        c.gridy++;

        c.gridx= 2;
        this.add(tittle_paid,c);
        c.gridx ++;
        this.add(tittle_amount,c );


        c.gridy++;

        //
        for (int i = 0; i <db.size() ; i++) {
            c.gridx = 0;
            Name[i] = new JLabel(db.getName(i));
            Amount[i] = new JTextField(10);
            Cost[i] = new JTextField(10);

            this.add(Name[i], c);
            c.gridx +=2;
            this.add(Amount[i],c );
            c.gridx ++;
            this.add(Cost[i], c);
            c.gridy ++;
        }

        c.gridx = 2;
        c.gridy++;
        this.add(AddTicket,c );
        c.gridx ++;
        this.add(Return,c );
        c.gridx = 0;
        c.gridy ++;
        this.add(rules1,c );
        c.gridx = 0;
        c.gridy ++;
        this.add(rules2,c);
     //   list.setBounds(500 ,300,75,75);
     //   this.add(list);
    }
    public void AddTicketListener(){
        final double[] amount_person = new double[1];
        final double[] cost_person = new double[1];
        this.AddTicket.addActionListener(l -> {
            for (int i = 0; i <db.size() ; i++) {
               // System.out.println("Amount: "+ Amount[i].getText());
                //System.out.println("Cost: "+ Cost[i].getText());
                //person id = i -> waarde amount en cost meegeven
                if(Amount[i].getText().matches("[0-9]+")) {
                 //   System.out.println("Amount: "+ Amount[i]);
                    amount_person[0] = Double.parseDouble(Amount[i].getText());
                } else
                    amount_person[0] = 0;
                if(Cost[i].getText().matches("[0-9]+")) {
                   // System.out.println("Amount: "+ Cost[i]);

                    cost_person[0] = Double.parseDouble(Cost[i].getText());
                } else
                    cost_person[0] = 0;

                controlPerson.addTicket(i, amount_person[0], cost_person[0]);
                Amount[i].setText("");
                Cost[i].setText("");
            }
            listListener();
        });
    }
    public void listListener(){
        String Data;
        if(list.getSelectedIndex() != -1){
            Data = list.getSelectedValue();
        } else
            Data = "Others";

        controlTicket.addTicketEntry(titleTicket.getText(),Data);
        dbTicket.printDatabase();
        titleTicket.setText("");

    }

    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(tittle);
            this.remove(AddTicket);
            this.remove(Return);
            this.remove(tittle_amount);
            this.remove(tittle_paid);
            for (int i = 0; i <db.size() ; i++) {

                this.remove(Name[i]);
                this.remove(Amount[i]);
                this.remove(Cost[i]);
            }
            this.remove(rules1);
            this.remove(rules2);
            this.remove(name_Ticket);
            this.remove(list);
            this.remove(titleTicket);
            c.gridy = 0;
            c.gridx = 0;

        });
    }

}
