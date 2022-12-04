package view.Menu;
import dbPerson.RegistrationdbPerson;
import dbTicket.RegistrationDbTicket;

import javax.swing.*;

public class ListPanel extends JPanel {
    private JList<RegistrationDbTicket> inputTicket;
    private DefaultListModel<RegistrationDbTicket> entryListTicket;

    private JList<RegistrationdbPerson> inputperson;
    private DefaultListModel<RegistrationdbPerson> entryListPerson;
    public ListPanel(){
        //person
        JLabel labelPerson = new JLabel("add person  ");
        entryListPerson = new DefaultListModel<>();
        inputperson = new JList<>(entryListPerson);

        JLabel labelTicket = new JLabel("add Ticket");
        entryListTicket = new DefaultListModel<>();
        inputTicket = new JList<>(entryListTicket);

        JLabel LabelBill = new JLabel("calculate Bill");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelPerson);
        this.add(inputperson);
        this.add(labelTicket);
        this.add(inputTicket);
        this.add(LabelBill);

    }
    public void addEntry(RegistrationdbPerson person){
        this.entryListPerson.addElement(person);
    }
}