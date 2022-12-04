package view.Person;

import javax.swing.*;
import java.awt.*;

public class PersonPanel extends JPanel {

    public PersonPanel(){
       // JLabel howmannyperson = new JLabel("how manny persons will u add?");
        JTextField textField = new JTextField("Text Field", 15);
        textField.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        textField.setForeground(Color.BLUE);
        textField.setHorizontalAlignment(JTextField.RIGHT);  // Text alignment
        textField.setToolTipText("type your name");
        //this.add(howmannyperson);
        this.add(textField);

    }


}
//wordt op dit moment niet gebruikt, nog even bewaren om de JTextfield gemakkelijk te bekijken
