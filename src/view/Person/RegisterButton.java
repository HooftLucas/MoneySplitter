package view.Person;


import Person.Person;
import controller.Person.RegistrationControlPerson;
import dbPerson.*;
import javax.swing.*;
import java.awt.*;



public class RegisterButton extends JPanel {

    private JTextField textField;
    private JButton AddName;
    private JButton Return;
    private JLabel label;
    private JButton deleteName;
    DefaultListModel<String> dbListModel = new DefaultListModel<>();

    JList<String> dbJList = new JList<>(dbListModel);
    private RegistrationControlPerson controlPerson;
    dbPerson dbPerson;
    protected GridBagConstraints c = new GridBagConstraints();
    DefaultListModel<String> Names;
    private JList<String> entryList;
    private JLabel[] Name;
    public RegisterButton(RegistrationControlPerson controlPerson, JFrame close, dbPerson dbPerson, GridBagConstraints c){
        this.dbPerson = dbPerson;
        this.label = new JLabel("add your friends");
        this.textField = new JTextField(10);
        this.controlPerson = controlPerson;
        this.Return = new JButton("return to menu");
        this.AddName = new JButton("add name");
        this.deleteName = new JButton("delete Name");
        this.c =c;
        addNameListener();
        DeleteNameListener();
        ReturnMenuListener(close);
        c.gridx = 0;
        c.gridy =0;
        this.setLayout(new GridBagLayout());

        Names = new DefaultListModel<>();
        entryList = new JList<>(Names);

        this.add(dbJList,c);
        c.gridy++;
        this.add(label,c);
        c.gridy++;
        this.add(this.textField,c);
        c.gridy++;
        this.add(this.AddName,c);
        c.gridx++;
        this.add(this.deleteName,c);
        c.gridy++;
        c.gridx =1;
        this.add(this.Return,c);
        c.gridx++;
        this.add(entryList,c);

    }
    public void addNameListener(){

        this.AddName.addActionListener(l -> {
            String name = textField.getText();
            controlPerson.addNameToDatabase(name);
            textField.setText("");
        });

    }
    public void DeleteNameListener(){
        this.deleteName.addActionListener(l -> {
            String name = textField.getText();
            System.out.println("control name");
            for (int i = 0; i < dbPerson.size(); i++){
                System.out.println(name);
                System.out.println(dbPerson.getPersonID(i).getName());
                if(name.equals(dbPerson.getPersonID(i).getName())){
                    System.out.println("delted person");
                    dbPerson.deletePerson(dbPerson.getPersonID(i));
                    textField.setText("");
                }
            }

        });

    }
    public void ReturnMenuListener(JFrame close){
        this.Return.addActionListener(e -> {
            close.dispose();
            this.remove(label);
            this.remove(this.textField);
            this.remove(this.AddName);
            this.remove(this.Return);
            this.remove(this.deleteName);
            this.remove(this.entryList);
            //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton
        });
    }
    public void showList(String name){
        this.Names.addElement(name);
        System.out.println(Names);
    }


}
