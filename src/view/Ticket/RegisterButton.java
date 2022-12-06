package view.Ticket;

import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterButton extends JPanel implements ActionListener {
   // private ArrayList<JTextField> Amount;
    private JTextField[] Amount = new JTextField[1000] ;
    private JTextField[] Cost = new JTextField[1000] ;
    private JButton AddTicket;
    private JButton Return;
    private JLabel tittle;

    private JLabel[] Name = new JLabel[100] ;

    private JLabel tittle_amount;
    private JLabel tittle_paid;

    private JLabel rules1;
    private JLabel rules2;
    private String[] Tickets = {"Culture", "Food", "Transport", "Others"};

    JList<String> list = new JList<>(Tickets);

    protected GridBagConstraints c = new GridBagConstraints();

    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    RegistrationControlTicket controlTicket;
    JList<String> dbJList = new JList<>(dbListModel);
    dbPerson db;

    RegisterButton(RegistrationControlTicket controlTicket, JFrame close, GridBagConstraints c, dbPerson db){
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

        AddTicketListener();
        listListener();
        ReturnMenuListener(close);

        this.add(dbJList);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());

        this.add(tittle,c );
        c.gridx+= 2;
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
        list.setBounds(500 ,300,75,75);
        this.add(list);
    }
    public void AddTicketListener(){

        this.AddTicket.addActionListener(l -> {
            for (int i = 0; i <db.size() ; i++) {
                //person id = i -> waarde amount en cost meegeven
                System.out.println(Amount[i].getText());
            }

        });
    }
    public void listListener(){
        String Data;
        if(list.getSelectedIndex() != -1){
            Data = list.getSelectedValue();
        }
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
            c.gridy = 0;
            c.gridx = 0;

        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
