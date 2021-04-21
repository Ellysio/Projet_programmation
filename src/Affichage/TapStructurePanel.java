package Affichage;

import javax.swing.*;
import java.awt.*;

public class TapStructurePanel extends JPanel {

    private JLabel label;
    private JTextField textField;

    public TapStructurePanel(int numero){
        super();
        this.label = new JLabel();
        if (numero == 1){
            this.label.setText("Tap your first structure :");
        }
        else if (numero == 2){
            this.label.setText("Tap your second structure :");
        }
        this.textField = new JTextField(70);
        //this.textField.setLocation(10,100);
        this.add(this.label);
        this.add(this.textField);
    }


}
