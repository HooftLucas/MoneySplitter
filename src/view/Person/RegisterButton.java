package view.Person;

import controller.Person.RegistrationControlPerson;
import dbPerson.*;
import javax.swing.*;
import java.awt.*;


public class RegisterButton extends JPanel {

    private final JTextField textField;
    private final JButton addName;
    private final JButton Return;
    private final JLabel label;
    private final JButton deleteName;
    private final RegistrationControlPerson controlPerson;
    private final JLabel dbContent;
    dbPerson dbPerson;
    protected GridBagConstraints c = new GridBagConstraints();
    
    private final JList<String> nameJList;
    private static DefaultListModel<String> nameListModel;


    public RegisterButton(RegistrationControlPerson controlPerson, JFrame close, dbPerson dbPerson, GridBagConstraints c){
        this.dbPerson = dbPerson;
        this.label = new JLabel("add your friends");
        this.textField = new JTextField(10);
        this.controlPerson = controlPerson;
        this.Return = new JButton("return to menu");
        this.addName = new JButton("add name");
        this.deleteName = new JButton("delete name");
        this.c =c;
        this.dbContent = new JLabel("people in database:");
        nameListModel = new DefaultListModel<>();
        nameJList = new JList<>(nameListModel);

        addNameListener();
        DeleteNameListener();
        ReturnMenuListener(close);

        c.gridx = 0;
        c.gridy =0;
        this.setLayout(new GridBagLayout());

        c.gridy++;
        this.add(label,c);
        c.gridy++;
        this.add(this.textField,c);
        c.gridy++;
        this.add(this.addName,c);
        c.gridx++;
        this.add(this.deleteName,c);
        c.gridy++;
        c.gridx = 0;
        this.add(this.Return,c);
        if(dbPerson.size()!=0){
            for(int i = 0; i < dbPerson.size(); i++){
                nameListModel.addElement(dbPerson.getPersonID(i).getName());
            }
        }
        //observer:
        c.gridy = 1;
        c.gridx = 2;
        this.add(dbContent,c);
        c.gridy++;
        this.add(nameJList,c);


    }

    public static void update(String name, boolean addOrDel) {
            if(addOrDel){
                nameListModel.addElement(name);
            }
            else {
                nameListModel.removeElement(name);
            }
        }


    public void addNameListener(){
        this.addName.addActionListener(l -> {
            String name = textField.getText();
            controlPerson.addNameToDatabase(name);
            textField.setText("");
        });

    }
    public void DeleteNameListener(){
        this.deleteName.addActionListener(l -> {
            String name = textField.getText();
            controlPerson.deleteNameFromDatabase(name);
            textField.setText("");
        });

    }
    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(label);
            this.remove(this.textField);
            this.remove(this.addName);
            this.remove(this.Return);
            this.remove(this.deleteName);
            this.remove(this.dbContent);
            this.remove(this.nameJList);
            //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton
        });
    }



}
