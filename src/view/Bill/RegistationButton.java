package view.Bill;

import Bill.Calculate;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ItemListener;

public class RegistationButton extends JPanel  {

    private JLabel[] Name = new JLabel[1000];
    private JLabel[] BalanceValue = new JLabel[1000];
    private JLabel titleBalance;
    private JLabel titleExchange;
    private JButton ReturnDeldb;

    private JButton Return;

    JFrame close;
    boolean canClose = false;
    int teller_hasPaid = 0;
    protected GridBagConstraints c = new GridBagConstraints();
    DefaultListModel<String> dbListModel = new DefaultListModel<>();
    JList<String> dbJList = new JList<>(dbListModel);
    dbPerson dbPerson;
    private JCheckBox[] hasPaid = new JCheckBox[100];
    private static final DecimalFormat df = new DecimalFormat("0.00");
    int teller = 0;
    boolean cleardb = false;
    HashMap<String, Double> BalanceMap =  Calculate.Balance();
    ArrayList<String> Exchange = Calculate.Exchange(BalanceMap);
    private JLabel[] lineToPaid= new JLabel[100];
    dbTicket dbTicket;

    RegistationButton(JFrame close, GridBagConstraints c, dbPerson dbPerson, dbTicket dbTicket){
        this.dbTicket = dbTicket;
        this.dbPerson = dbPerson;
        this.c =c;
        this.close = close;

        titleBalance = new JLabel("Balance: ");
        titleExchange = new JLabel("Exchange: ");
        ReturnDeldb = new JButton("return -> bill will be deleted");
        Return = new JButton("Return -> add tickets");

        ReturnClearListener();
        ReturnListener();

        //this.add(dbJList);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());


        // Balance
        this.add(titleBalance,c);
        c.gridy += 2 ;
        for (int i = 0; i < dbPerson.size() ; i++) {
            c.gridx = 0;
            Name[i] = new JLabel(dbPerson.getName(i) + " : ");
            BalanceValue[i] = new JLabel(df.format(BalanceMap.get(dbPerson.getName(i))) + "€");
            this.add(Name[i], c);
            c.gridx ++;
            this.add(BalanceValue[i],c );
            c.gridy ++;
        }

        // Exchange:
        c.gridy ++;
        c.gridx = 0;
        this.add(titleExchange,c);
        c.gridy ++;
        for( String line : Exchange) {
            hasPaid[teller] = new JCheckBox();
            lineToPaid[teller] = new JLabel(line);
            this.add(lineToPaid[teller], c);
            c.gridx ++;
            this.add(hasPaid[teller],c);
            c.gridy ++;
            c.gridx = 0;
            teller++;
        }
        this.add(Return, c);
        c.gridx++;
        this.add(ReturnDeldb,c);


        controlCheckBox(teller);
        canReturn(teller);
    }

    public void ReturnListener(){
        this.Return.addActionListener(e -> {
            cleardb = false;
            exit(cleardb);
        });
    }
    public void ReturnClearListener(){
        this.ReturnDeldb.addActionListener(e -> {
            cleardb = true;
            if(canClose)
                exit(cleardb);
        });
    }
    public void controlCheckBox(int teller) {



        for (int i = 0; i < teller; i++) {
            hasPaid[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        teller_hasPaid +=1;
                        System.out.println("er wordt op het vakje geduwd " + teller_hasPaid);

                    }
                }
            });

        }

    }
    void canReturn(int teller ){
        System.out.println(teller);
        System.out.println(teller_hasPaid);
        if (teller_hasPaid == teller) {
            canClose = true;
            System.out.println("can close");
        } // via observer
    }

    void exit(boolean cleardb){
        close.dispose();
        this.remove(titleBalance);
        this.remove(titleExchange);
        this.remove(ReturnDeldb);
        this.remove(Return);
        for (int i = 0; i < dbPerson.size() ; i++) {
            this.remove(Name[i]);
            this.remove(BalanceValue[i]);
        }
        for (int j = 0; j< teller; j++){
            this.remove(hasPaid[j]);
            this.remove(lineToPaid[j]);
        }
        if (cleardb){
            for(int j= dbTicket.size(); j > 0; j--){
              //  System.out.println(dbTicket.getTicketID(j));
                dbTicket.deleteTicket(dbTicket.getTicketID(j));

            }
            for(int i = dbPerson.size(); i > 0; i--){
               // System.out.println(dbPerson.getPersonID(i));
                dbPerson.deletePerson(dbPerson.getPersonID(i));
            }

        }

        teller = 0;

        c.gridy = 0;
        c.gridx = 0;
    }


}
