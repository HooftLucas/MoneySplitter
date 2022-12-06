package view.Ticket;

import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterButton extends JPanel implements ActionListener {
    private JTextField Amount;
    private JTextField Cost;
    private JButton AddTicket;
    private JButton Return;
    private JLabel tittle;
    private JLabel personName;
    private JLabel tittle_amount;
    private JLabel tittle_paid;

    protected GridBagConstraints c = new GridBagConstraints();

    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    RegistrationControlTicket controlTicket;
    JList<String> dbJList = new JList<>(dbListModel);

    RegisterButton(RegistrationControlTicket controlTicket, JFrame close, GridBagConstraints c, dbPerson db){
        this.c =c;
        this.controlTicket = controlTicket;
        tittle = new JLabel("Add your ticket");
        Amount = new JTextField(10);
        Cost = new JTextField(10);
        AddTicket = new JButton("add Ticket");
        Return = new JButton("Return");
        tittle_amount = new JLabel("who have paid");
        tittle_paid = new JLabel("total bill");

        AddTicketListener();
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
            personName = new JLabel(db.getName(i));
            this.add(personName, c);
            c.gridx +=2;
            this.add(Amount,c );
            c.gridx ++;
            this.add(Cost, c);
            c.gridy ++;
        }
        this.add(AddTicket,c );
        c.gridy ++;
        this.add(Return,c );



    }
    public void AddTicketListener(){

        this.AddTicket.addActionListener(l -> {
            //Double PersonPaid = Double.valueOf(Amount.getText());
            //Double needTopay = Double.valueOf(Cost.getText());
            //controlTicket.addTicketEntry(PersonPaid,needTopay );
            //kijken waar ik dit moet importeren
        });
    }

    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

// for (int i = 0; i < db.size(); i++) {
//                if (db.getPersonID(i).getName() == Name) {
//                    System.out.println(Name+" is already in the DB: ");
//                    nameInDb = true;
//                    return;
//                } else
//                    nameInDb = false;
//            }
//            if (!nameInDb) {
//                db.addPerson(new Person(Name));
//                System.out.println(Name + " is added in the database");
//
//            }
//        }