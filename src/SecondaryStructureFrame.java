import javax.swing.*;

public class SecondaryStructureFrame extends JFrame{

    // Constructors
    public SecondaryStructureFrame(){
        super();
        setTitle("Comparaison de structures secondaires");
        setSize(400,500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){



        SecondaryStructureFrame f = new SecondaryStructureFrame();
        f.setVisible(true);

    }




}
