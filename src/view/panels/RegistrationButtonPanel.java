package view.panels;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.RegistrationdbPerson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationButtonPanel extends JPanel implements ActionListener {
    private JButton addPerson;
    private RegistrationControlPerson controller;
    private Person person;
    public RegistrationButtonPanel(RegistrationControlPerson regPer){
        JLabel label = new JLabel("Split your bills");
        this.addPerson = new JButton("add persons");
        this.controller = regPer;

        addPersonActionListener();
        this.setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
        this.add(this.addPerson);
    }
    public void addPersonActionListener(){
        this.addPerson.addActionListener(listener -> {
            controller.ConfirmName("Bob");
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        String nameEmployee;
        if(s.equals("submit")){
            nameEmployee = s;

        }

    }
}
