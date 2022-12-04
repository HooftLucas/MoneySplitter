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

    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    RegistrationControlTicket controlTicket;
    JList<String> dbJList = new JList<>(dbListModel);
    RegisterButton(RegistrationControlTicket controlTicket, JFrame close, dbPerson db){
        this.controlTicket = controlTicket;
        JLabel label = new JLabel("Add your ticket");
        this.Amount = new JTextField();
        this.Cost = new JTextField();
        this.AddTicket = new JButton("add Ticket");
        this.Return = new JButton("Return");
        AddTicketListener();
        ReturnMenuListener(close);

        this.add(dbJList);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(label);
        //
        for (int i = 0; i <db.size() ; i++) {

            this.add(this.Amount);
            this.add(this.Cost);
        }
        this.add(this.AddTicket);
        this.add(this.Return);



    }
    public void AddTicketListener(){

        this.AddTicket.addActionListener(l -> {
            Double PersonPaid = Double.valueOf(Amount.getText());
            Double needTopay = Double.valueOf(Cost.getText());
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