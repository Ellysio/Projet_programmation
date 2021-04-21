package Affichage;

import javax.swing.*;

public class SecondaryStructureFrame extends JFrame{

    // Constructors
    public SecondaryStructureFrame(){
        super();
        setTitle("ARN secondary structure comparison");
        setSize(1200,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SecondaryStructurePanel());
    }

    public static void main(String[] args){



        SecondaryStructureFrame f = new SecondaryStructureFrame();
        f.setVisible(true);

    }




}
