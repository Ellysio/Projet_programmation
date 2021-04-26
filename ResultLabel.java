import javax.swing.*;
import java.awt.*;

public class ResultLabel extends JLabel {

    public ResultLabel(String message){
        super();
        this.setText(message);
    }

    public ResultLabel(String message,boolean error){
        super();
        this.setText(message);
        if (error == true){
            this.setForeground(Color.RED);
        }
    }

}
