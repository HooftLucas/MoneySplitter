package view.Person;


import controller.Person.RegistrationControlPerson;
import dbPerson.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class RegisterButton extends JPanel implements KeyListener {

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


    }
    public void addNameListener(){

        this.AddName.addActionListener(l -> {
            String name = textField.getText();
            controlPerson.addNameToDatabase(name);

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
    public void clearText(boolean cleartruetext){
        System.out.println("test");
        if (cleartruetext)
            textField.setText("");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("enter");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
 //observer toevoegen -> kijken als op de knop gedrukt wordt om alle vakjes leeg te maken