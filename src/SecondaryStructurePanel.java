import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryStructurePanel extends JPanel implements ActionListener {

    private TapPanelGlobal tapPanelSequence1 = new TapPanelGlobal(1);
    private TapPanelGlobal tapPanelSequence2 = new TapPanelGlobal(2);
    private SecondaryStructureButton b = new SecondaryStructureButton();

    public SecondaryStructurePanel(){
        super(new GridLayout(3,1));
        this.add(tapPanelSequence1);
        this.add(tapPanelSequence2);
        this.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == b){
            ARN sequence1 = new ARN();
            ARN sequence2 = new ARN();
            if (!tapPanelSequence1.getTextSequence().isEmpty()){
                try {
                    sequence1.setSequence(tapPanelSequence1.getTextSequence());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    sizeNotCorrectException.printStackTrace();
                }
                catch (SequenceNotCorrectException sequenceNotCorrectException){
                    sequenceNotCorrectException.printStackTrace();
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
                } catch (SizeNotCorrectException | SequenceNotCorrectException sizeNotCorrectException) {
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

            if (sequence1.isEmpty()){
                ResultFrame f = new ResultFrame(" Error : the first sequence is empty.",300,true);
                f.setVisible(true);
            }
            else if (sequence2.isEmpty()){
                ResultFrame f = new ResultFrame(" Error : the second sequence is empty.",300,true);
                f.setVisible(true);
            }
            else if (sequence1.size() >= sequence2.size()){
                if (sequence1.contains(sequence2)){
                    ResultFrame f = new ResultFrame(" The first sequence contains the second sequence.",310,false);
                    f.setVisible(true);
                }
                else {
                    ResultFrame f = new ResultFrame(" The first sequence does not contain the second sequence.",360,false);
                    f.setVisible(true);
                }
            }
            else {
                if (sequence2.contains(sequence1)) {
                    ResultFrame f = new ResultFrame(" The second sequence contains the first sequence.",310,false);
                    f.setVisible(true);
                } else {
                    ResultFrame f = new ResultFrame(" The second sequence does not contain the first sequence.",360,false);
                    f.setVisible(true);
                }
            }
        }
    }

}
