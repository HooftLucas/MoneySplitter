package view;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.RegistrationdbPerson;
import view.panels.ListPanel;
import view.panels.RegistrationButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class viewFrame extends JFrame implements Observer {
    private RegistrationControlPerson regPerson;
    ListPanel panel;
    RegistrationButtonPanel buttons;
    public viewFrame(){
        super("add Person");
    }
    public void initialize(RegistrationControlPerson regPerson){
        this.setSize(700,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegistrationButtonPanel(regPerson);
        panel = new ListPanel();

        this.add(panel);
        this.add(buttons);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Person p= (Person) arg;
        String name = p.getName();
        RegistrationdbPerson rPerson = RegistrationdbPerson.getInstance();

    }
}
