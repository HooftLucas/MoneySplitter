package view.Person;

import controller.Person.RegistrationControlPerson;
import dbPerson.dbPerson;

import javax.swing.*;
import java.awt.*;

public class ViewPerson extends JFrame {
    RegistrationControlPerson controlPerson;
    RegisterButton buttons;
    dbPerson dbPerson;
    public ViewPerson(){ super("give up your friends");}
    public void initialize(RegistrationControlPerson controlPerson, dbPerson dbPerson){
        this.dbPerson = dbPerson;
        this.controlPerson = controlPerson;
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new RegisterButton(controlPerson, this, dbPerson);
        this.add(buttons);
        this.setVisible(true);
    }


}
