package view.Bill;

import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistationButton extends JPanel implements ActionListener {
    private JLabel[] to_paid = new JLabel[1000];
    private JLabel[] PersonToPaid = new JLabel[1000];
    private JLabel[] Name = new JLabel[1000];
    private JLabel title;
    private JLabel titlePaid;
    private JLabel titlePersonToPaid;
    private JButton Return;
    protected GridBagConstraints c = new GridBagConstraints();
    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    RegistrationControlTicket controlTicket;
    JList<String> dbJList = new JList<>(dbListModel);
    dbPerson dbP;
    RegistationButton(RegistrationControlTicket controlTicket, JFrame close, GridBagConstraints c, dbPerson dbP, dbTicket dbT){
        this.dbP = dbP;
        this.c =c;
        this.controlTicket = controlTicket;
        title = new JLabel("the total bill: ");
        titlePaid = new JLabel("amount to pay");
        titlePersonToPaid = new JLabel("Person to pay");
        Return = new JButton("return -> bill will be deleted");

        ReturnListener(close);
        this.add(dbJList);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());
        for (int i = 0; i <dbP.size() ; i++) {
            c.gridx = 0;
            Name[i] = new JLabel(dbP.getName(i));
            //to_paid[i] = new JLabel(); -> waarde uit ticket halen
            //PersonToPaid[i] = new JLabel();

            this.add(Name[i], c);
            c.gridx +=2;
            //this.add(to_paid[i],c );
            c.gridx ++;
           // this.add(PersonToPaid[i], c);
            c.gridy ++;
        }
    }
    public void ReturnListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(title);
            this.remove(Return);
            for (int i = 0; i <dbP.size() ; i++) {

                this.remove(Name[i]);
               // this.remove(to_paid[i]);
               // this.remove(PersonToPaid[i]);
            }

            c.gridy = 0;
            c.gridx = 0;

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
