package view.Bill;

import Bill.Calculate;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistationButton extends JPanel  {

    private final JLabel[] Name = new JLabel[1000];
    private final JLabel[] BalanceValue = new JLabel[1000];
    private final JLabel titleBalance;
    private final JLabel titleExchange;
    private final JButton Deletedb;
    private final JButton Return;

    JFrame close;
    boolean canClose = false;
    int teller_hasPaid = 0;
    protected GridBagConstraints c;
    dbPerson dbPerson;
    private final JCheckBox[] hasPaid = new JCheckBox[100];
    private static final DecimalFormat df = new DecimalFormat("0.00");
    int teller = 0;
    HashMap<String, Double> BalanceMap =  Calculate.Balance();
    ArrayList<String> Exchange = Calculate.Exchange(BalanceMap);
    private final JLabel[] lineToPaid= new JLabel[100];
    dbTicket dbTicket;

    RegistationButton(JFrame close, GridBagConstraints c, dbPerson dbPerson, dbTicket dbTicket){
        this.dbTicket = dbTicket;
        this.dbPerson = dbPerson;
        this.c =c;
        this.close = close;

        titleBalance = new JLabel("Balance: ");
        titleExchange = new JLabel("Exchange: ");
        Deletedb = new JButton("Finish");
        Return = new JButton("Return");

        ReturnClearListener();
        ReturnListener();

        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());

        // Balance
        this.add(titleBalance,c);
        c.gridy += 2 ;
        for (int i = 0; i < dbPerson.size() ; i++) {
            c.gridx = 0;
            Name[i] = new JLabel(dbPerson.getPersonID(i).getName() + " : ");
            BalanceValue[i] = new JLabel(df.format(BalanceMap.get(dbPerson.getPersonID(i).getName())) + "€");
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
        this.add(Deletedb,c);


        controlCheckBox(teller);

    }

    public void ReturnListener(){
        this.Return.addActionListener(e -> exit(false));
    }
    public void ReturnClearListener(){
        this.Deletedb.addActionListener(e -> {
            if(canClose)
                exit(true);
        });
    }
    public void controlCheckBox(int teller) {
        for (int i = 0; i < teller; i++) {
            hasPaid[i].addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    teller_hasPaid +=1;
                    if (teller_hasPaid == teller) {
                        canClose = true;
                    }
                }
            });
        }
    }

    void exit(boolean cleardb){
        close.dispose();
        this.remove(titleBalance);
        this.remove(titleExchange);
        this.remove(Deletedb);
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
            dbPerson.clear();
            dbTicket.clear();
        }

        teller = 0;

        c.gridy = 0;
        c.gridx = 0;
    }


}
