import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResultFrame extends JFrame {

    ResultButton b = new ResultButton();

    // Constructors
    public ResultFrame(String message,int width){
        super(message);
        this.setTitle("Comparison results");
        this.setSize(width,80);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ResultLabel l = new ResultLabel(message);
        this.getContentPane().add(l);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2 - 200);
    }

    public static void main(String[] args){

        ResultFrame f = new ResultFrame("Bla",300);
        f.setVisible(true);

    }

}
