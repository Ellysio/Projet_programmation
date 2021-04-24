import javax.swing.*;
import java.awt.*;

public class SecondaryStructureFrame extends JFrame{

    // Constructors
    public SecondaryStructureFrame(){
        super();
        this.setTitle("ARN secondary structure comparison");
        this.setSize(1200,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new SecondaryStructurePanel());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2 - 200);
    }

    public static void main(String[] args){

        SecondaryStructureFrame f = new SecondaryStructureFrame();
        f.setVisible(true);

    }

}
