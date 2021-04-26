import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private ResultLabel l;

    // Constructors
    public ResultFrame(String message,int width,boolean error){
        super(message);
        this.setTitle("Comparison results");
        this.setSize(width,80);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        l = new ResultLabel(message,error);
        this.getContentPane().add(l);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2 - 200);
    }

    public static void main(String[] args){

        ResultFrame f = new ResultFrame("Bla",300,true);
        f.setVisible(true);

    }

}
