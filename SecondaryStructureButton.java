import javax.swing.*;
import java.awt.*;

public class SecondaryStructureButton extends JButton {

    public SecondaryStructureButton(){
        super("Launch comparison");
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
    }

    public Dimension getPreferredSize(){
        return new Dimension(200,50);
    }

}
