package view.panels;

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
        JLabel label = new JLabel("add person  ");
        entryListPerson = new DefaultListModel<>();
        inputperson = new JList<>(entryListPerson);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(inputperson);

    }
    public void addEntry(RegistrationdbPerson person){
        this.entryListPerson.addElement(person);
    }
}
