import javax.swing.*;
import java.awt.*;

public class SecondaryStructureLabel extends JLabel {

    public SecondaryStructureLabel(Integer numero){
        super("Tap your structure n°" + numero.toString());
        setLayout(new GridLayout(2,2));
    }

}
