package view.Person;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.RegistrationdbPerson;
import view.Menu.ListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewPerson extends JFrame implements Observer {
    RegistrationControlPerson controlPerson;
    RegisterButton buttons;
    public ViewPerson(){ super("give up your friends");}
    public void initialize(RegistrationControlPerson controlPerson){
        this.controlPerson = controlPerson;
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegisterButton(controlPerson, this);
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
