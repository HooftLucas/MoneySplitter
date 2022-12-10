package view.Person;

import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.dbPerson;

import javax.swing.*;

public class RegisterButton extends JPanel {

    private JTextField textField;
    private JButton AddName;
    private JButton Return;
    private JLabel label;
    DefaultListModel<String> dbListModel = new DefaultListModel<>();

    JList<String> dbJList = new JList<>(dbListModel);
    private RegistrationControlPerson controlPerson;
    dbPerson dbPerson;
    public RegisterButton(RegistrationControlPerson controlPerson, JFrame close, dbPerson dbPerson){
        this.dbPerson = dbPerson;
        this.label = new JLabel("add your friends");
        this.textField = new JTextField();
        this.controlPerson = controlPerson;
        this.Return = new JButton("return to menu");
        this.AddName = new JButton("add name");
        addNameListener();
        ReturnMenuListener(close);

        this.add(dbJList);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(label);
        this.add(this.textField);
        this.add(this.AddName);
        this.add(this.Return);
// verwijder uit lijst

    }
    public void addNameListener(){

        this.AddName.addActionListener(l -> {
            String name = textField.getText();
            controlPerson.addNameToDatabase(name);
            textField.setText("");
            //db.printDatabase();
        });
    }
    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(label);
            this.remove(this.textField);
            this.remove(this.AddName);
            this.remove(this.Return);
            //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton
        });
    }
    public void addEntry(Person entry){this.dbListModel.addElement(String.valueOf(entry));}

}
