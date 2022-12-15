package view.Bill;

import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewBill extends JFrame implements Observer {
    RegistationButton buttons;
    protected GridBagConstraints c = new GridBagConstraints();
    public ViewBill(){super("give the total bill");}
    public void initialize(dbPerson dbPerson, dbTicket dbTicket){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistationButton(this, c, dbPerson, dbTicket);
        this.add(buttons);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        //controleren of de vakjes zijn gekleurd voor het de database gecleerd kan worden

    }
}
