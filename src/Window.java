import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        super();
        WindowCreation ();
    }

    public void WindowCreation () {
       setTitle("RNA Secondary Structure");
       setSize(1200,600);
       setVisible(true);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setContentPane(windowcontent());
    }

   public  JPanel windowcontent(){
       JPanel p = new JPanel();
       p.setLayout(new FlowLayout());
       //JLabel l = new JLabel("welcome");
       JButton button= new JButton(new RnaSeconStruc(this,"Tap your matching here!"));
       p.add(button);
       JTextField matching = new JTextField();
       matching.setColumns(100);
       p.add(matching);
       return p;
   }

}
