package view.Ticket;

import controller.Person.RegistrationControlPerson;
import controller.Ticket.RegistrationControlTicket;
import dbPerson.dbPerson;
import dbTicket.dbTicket;

import javax.swing.*;
import java.awt.*;


public class RegisterButton extends JPanel {
    private final JTextField[] amount = new JTextField[1000];
    private final JTextField[] cost = new JTextField[1000];
    private final JCheckBox[] participate = new JCheckBox[100];

    private final JTextField title_ticket;
    private final JButton addTicket;
    private final JButton Return;
    private final JLabel title;

    private final JLabel[] name = new JLabel[100];

    private final JLabel title_amount;
    private final JLabel title_paid;

    private final JLabel name_ticket;
    private final JLabel title_participate;

    private final String[] Tickets = {"Culture", "Food", "Transport"};
    JList<String> list = new JList<>(Tickets);

    protected GridBagConstraints c = new GridBagConstraints();
    RegistrationControlTicket controlTicket;
    dbPerson dbPerson;
    RegistrationControlPerson controlPerson;
    dbTicket dbTicket;


    RegisterButton(RegistrationControlTicket controlTicket, JFrame close, GridBagConstraints c, dbPerson dbPerson, RegistrationControlPerson controlPerson, dbTicket dbTicket) {
        this.controlPerson = controlPerson;
        this.dbTicket = dbTicket;
        this.c = c;
        this.dbPerson = dbPerson;
        this.controlTicket = controlTicket;
        title = new JLabel("add your ticket");
        addTicket = new JButton("add ticket");
        Return = new JButton("return");
        title_amount = new JLabel("amount paid");
        title_paid = new JLabel("cost to be paid");
        title_ticket = new JTextField(10);
        name_ticket = new JLabel("give the name of your ticket");
        title_participate = new JLabel("participated");

        AddTicketListener();
        ReturnMenuListener(close);

        c.gridy = 0;
        c.gridx = 0;
        this.setLayout(new GridBagLayout());

        this.add(title, c);
        c.gridy++;
        c.gridx = 0;
        this.add(name_ticket, c);
        c.gridx += 2;
        this.add(title_ticket, c);
        c.gridx++;
        this.add(list, c);
        c.gridy++;

        c.gridx = 2;
        this.add(title_amount, c);
        c.gridx++;
        this.add(title_paid, c);
        c.gridx++;
        this.add(title_participate, c);
        c.gridy++;

        //
        for (int i = 0; i < dbPerson.size(); i++) {
            c.gridx = 0;
            name[i] = new JLabel(dbPerson.getPersonID(i).getName());
            amount[i] = new JTextField(10);
            cost[i] = new JTextField(10);
            participate[i] = new JCheckBox();
            participate[i].setSelected(true);

            this.add(name[i], c);
            c.gridx += 2;
            this.add(amount[i], c);
            c.gridx++;
            this.add(cost[i], c);
            c.gridx++;
            this.add(participate[i], c);
            c.gridy++;
        }

        c.gridx = 2;
        c.gridy++;
        this.add(addTicket, c);
        c.gridx++;
        this.add(Return, c);

        // controlCheckBoxTicket();

    }

    public void AddTicketListener() {
        final double[] amount_person = new double[1];
        final double[] cost_person = new double[1];
        this.addTicket.addActionListener(l -> {
            for (int i = 0; i < dbPerson.size(); i++) {
                //person id = i -> waarde amount, cost en doPay meegeven
                if (amount[i].getText().matches("[0-9]+")) {
                    amount_person[0] = Double.parseDouble(amount[i].getText());
                } else
                    amount_person[0] = 0;
                if (cost[i].getText().matches("[0-9]+")) {
                    cost_person[0] = Double.parseDouble(cost[i].getText());
                } else
                    cost_person[0] = 0;
                controlPerson.setPersonForTicket(i, amount_person[0], cost_person[0], participate[i].isSelected());
                amount[i].setText("");
                cost[i].setText("");
                participate[i].setSelected(true);
            }
            listListener();
        });
    }

    public void listListener() {
        String Data;
        if (list.getSelectedIndex() != -1) {
            Data = list.getSelectedValue();
        } else
            Data = "Others";

        controlTicket.addTicketEntry(title_ticket.getText(), Data);
        dbTicket.printDatabase();
        title_ticket.setText("");

    }


    public void ReturnMenuListener(JFrame close) {
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(title);
            this.remove(addTicket);
            this.remove(Return);
            this.remove(title_amount);
            this.remove(title_paid);
            for (int i = 0; i < dbPerson.size(); i++) {
                this.remove(name[i]);
                this.remove(amount[i]);
                this.remove(cost[i]);
                this.remove(participate[i]);
            }
            this.remove(name_ticket);
            this.remove(list);
            this.remove(title_ticket);
            this.remove(title_participate);
            c.gridy = 0;
            c.gridx = 0;
        });
    }



}


