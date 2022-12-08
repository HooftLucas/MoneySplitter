package view.Person;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import dbPerson.RegistrationdbPerson;

public class ViewPerson extends JFrame {
    RegistrationControlPerson controlPerson;
    RegisterButton buttons;
    dbPerson db;
    public ViewPerson(){ super("give up your friends");}
    public void initialize(RegistrationControlPerson controlPerson, dbPerson db){
        this.db = db;
        this.controlPerson = controlPerson;
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegisterButton(controlPerson, this, db);
        this.add(buttons);
        this.setVisible(true);
    }


}
