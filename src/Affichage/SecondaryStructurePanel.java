package Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryStructurePanel extends JPanel implements ActionListener {

    TapStructurePanel t1 = new TapStructurePanel(1);
    TapStructurePanel t2 = new TapStructurePanel(2);
    SecondaryStructureButton b = new SecondaryStructureButton();

    public SecondaryStructurePanel(){
        super(new GridLayout(3,1));
        this.add(t1);
        this.add(t2);
        this.add(b);
        b.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        Object source = e.getSource();
        if (source == b){
            System.out.println("test");
            String matching1 = t1.getTextField().getText();
            String matching2 = t2.getTextField().getText();

        }

    }



}
