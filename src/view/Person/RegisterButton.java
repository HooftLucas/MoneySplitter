package view.Person;

import controller.Person.RegistrationControlPerson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RegisterButton extends JPanel implements ActionListener {

    private JTextField textField;
    private JButton AddName;
    private JButton Return;
    DefaultListModel<String> dbListModel = new DefaultListModel<>();

    JList<String> dbJList = new JList<>(dbListModel);
    private RegistrationControlPerson controlPerson;
    Boolean firstTime = true;
    public RegisterButton(RegistrationControlPerson controlPerson, JFrame close){

        JLabel label = new JLabel("add your friends");
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
            controlPerson.ConfirmName(name);
        });
    }
    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton
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
