package view.error;

import javax.swing.*;
import java.awt.*;

public class ViewError extends JFrame{
    public ViewError(){super("Error!");}
    RegistrationButtonPanel buttons;
    public void initialize(String title, String Tolittle) {
        this.setSize(700, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        buttons = new view.error.RegistrationButtonPanel(this, title, Tolittle);

        this.add(buttons);
        this.setVisible(true);
    }
}
