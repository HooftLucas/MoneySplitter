package view.Bill;

import Bill.Calculate;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class RegistationButton extends JPanel {

    private JLabel[] Name = new JLabel[1000];
    private JLabel[] BalanceValue = new JLabel[1000];
    private JLabel titleBalance;
    private JLabel titleExchange;
    private JButton Return;
    protected GridBagConstraints c = new GridBagConstraints();
    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    JList<String> dbJList = new JList<>(dbListModel);
    dbPerson dbPerson;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    RegistationButton(JFrame close, GridBagConstraints c, dbPerson dbPerson, dbTicket dbTicket){
        this.dbPerson = dbPerson;
        this.c =c;
        HashMap<String, Double> Balance =  Calculate.Balance();
        titleBalance = new JLabel("Balance: ");
        titleExchange = new JLabel("Exchange: ");
        Return = new JButton("return -> bill will be deleted");

        ReturnListener(close);

        //this.add(dbJList);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());

        this.add(titleBalance,c);
        c.gridy += 2 ;
        for (int i = 0; i < dbPerson.size() ; i++) {
            c.gridx = 0;
            Name[i] = new JLabel(dbPerson.getName(i) + " : ");
            BalanceValue[i] = new JLabel(df.format(Balance.get(dbPerson.getName(i))) + "€");
            this.add(Name[i], c);
            c.gridx ++;
            this.add(BalanceValue[i],c );
            c.gridy ++;
        }

        c.gridy ++;
        c.gridx = 0;
        this.add(titleExchange,c);


    }

    public void ReturnListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(titleBalance);
            this.remove(titleExchange);
            this.remove(Return);
            for (int i = 0; i < dbPerson.size() ; i++) {
                this.remove(Name[i]);
                this.remove(BalanceValue[i]);
            }
            c.gridy = 0;
            c.gridx = 0;
        });
    }

}
