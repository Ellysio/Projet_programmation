import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryStructurePanel extends JPanel implements ActionListener {

    TapPanelGlobal tapPanelSequence1 = new TapPanelGlobal(1);
    TapPanelGlobal tapPanelSequence2 = new TapPanelGlobal(2);
    SecondaryStructureButton b = new SecondaryStructureButton();

    public SecondaryStructurePanel(){
        super(new GridLayout(3,1));
        this.add(tapPanelSequence1);
        this.add(tapPanelSequence2);
        this.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        Object source = e.getSource();
        if (source == b){
            System.out.println("test");
            ARN sequence1 = new ARN();
            ARN sequence2 = new ARN();
            if (!tapPanelSequence1.getTextSequence().isEmpty()){
                try {
                    sequence1.setSequence(tapPanelSequence1.getTextSequence());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    sizeNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence1.getTextStructure().isEmpty()) {
                try {
                    sequence1.setMatching(tapPanelSequence1.getTextStructure());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    sizeNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException) {
                    matchingNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence2.getTextSequence().isEmpty()){
                try {
                    sequence2.setSequence(tapPanelSequence2.getTextSequence());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    sizeNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence2.getTextStructure().isEmpty()) {
                try {
                    sequence2.setMatching(tapPanelSequence2.getTextStructure());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    sizeNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException) {
                    matchingNotCorrectException.printStackTrace();
                }
            }
            System.out.println("sequence1 :\n" + sequence1);
            System.out.println("sequence2 :\n" + sequence2);



        }

    }



}
