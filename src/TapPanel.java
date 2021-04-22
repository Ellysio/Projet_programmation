import javax.swing.*;
import java.awt.*;

public class TapPanel extends JPanel {

    private JLabel label;
    private JTextField textField;

    public TapPanel(boolean sequence, int numero){
        super();
        this.label = new JLabel();
        if (sequence == true){
            if (numero == 1){
                this.label.setText("Tap your first sequence :");
            }
            else if (numero == 2){
                this.label.setText("Tap your second sequence :");
            }
        }
        else {
            if (numero == 1){
                this.label.setText("Tap your first structure :");
            }
            else if (numero == 2){
                this.label.setText("Tap your second structure :");
            }
        }
        this.textField = new JTextField(70);
        //this.textField.setLocation(10,100);
        this.add(this.label);
        this.add(this.textField);
    }

    public String getText(){
        return this.textField.getText();
    }

}
