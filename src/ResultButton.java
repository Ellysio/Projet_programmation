import javax.swing.*;
import java.awt.*;

public class ResultButton extends JButton {

    public ResultButton(){
        super("Ok");
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 12));
    }

    public Dimension getPreferredSize(){
        return new Dimension(40,50);
    }

}
