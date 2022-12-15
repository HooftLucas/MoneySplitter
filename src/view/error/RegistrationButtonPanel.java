package view.error;

import javax.swing.*;

public class RegistrationButtonPanel extends JPanel {
    private final JButton Return;
    JLabel Error;
    public RegistrationButtonPanel(JFrame close,String title, String ToLittle){
        Error = new JLabel("error: there are not enough "+ToLittle + " to make a "+ title);
        this.Return = new JButton("Return");

        addReturnlistener(close);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(Error);
        this.add(this.Return);
    }
    public void addReturnlistener(JFrame close){
        this.Return.addActionListener(l-> {
            close.dispose();
            this.remove(Error);
            this.remove(this.Return);
        });
    }
}
