package view.Person;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class ViewPerson extends JFrame implements Observer {
    RegistrationControlPerson controlPerson;
    RegisterButton buttons;
    dbPerson dbPerson;
    RegistrationdbPerson regPerson;

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


    @Override
    public void update(Observable o, Object arg) {
        Person p = (Person) arg;
        buttons.clearText(regPerson.checkDb(p));
        System.out.println("clear textfield");
    }



}
