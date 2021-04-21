package Affichage;

import javax.swing.*;
import java.awt.*;

public class SecondaryStructurePanel extends JPanel {

    public SecondaryStructurePanel(){
        super(new GridLayout(3,1));
        this.add(new TapStructurePanel(1));
        this.add(new TapStructurePanel(2));
        //this.add(new SecondaryStructureTextField());
        this.add(new SecondaryStructureButton());
    }

}
