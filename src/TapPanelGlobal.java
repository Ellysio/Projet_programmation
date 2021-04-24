import javax.swing.*;
import java.awt.*;

public class TapPanelGlobal extends JPanel {

    private TapPanel tapPanelSequence;
    private TapPanel tapPanelStructure;

    public TapPanelGlobal(int numero){
        super(new GridLayout(2,1));
        this.tapPanelSequence = new TapPanel(true,numero);
        this.tapPanelStructure = new TapPanel(false,numero);
        this.add(tapPanelSequence);
        this.add(tapPanelStructure);
    }

    public String getTextSequence(){
        return this.tapPanelSequence.getText();
    }

    public String getTextStructure(){
        return this.tapPanelStructure.getText();
    }

}
