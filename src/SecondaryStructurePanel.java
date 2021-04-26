import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryStructurePanel extends JPanel implements ActionListener {

    private final TapPanelGlobal tapPanelSequence1 = new TapPanelGlobal(1);
    private final TapPanelGlobal tapPanelSequence2 = new TapPanelGlobal(2);
    private final SecondaryStructureButton b = new SecondaryStructureButton();

    public SecondaryStructurePanel(){
        super(new GridLayout(3,1));
        this.add(tapPanelSequence1);
        this.add(tapPanelSequence2);
        this.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean exception = false;
        Object source = e.getSource();
        if (source == b){
            ARN sequence1 = new ARN();
            ARN sequence2 = new ARN();
            if (!tapPanelSequence1.getTextSequence().isEmpty()){
                try {
                    sequence1.setSequence(tapPanelSequence1.getTextSequence());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    exception = true;
                    sizeNotCorrectException.printStackTrace();
                }
                catch (SequenceNotCorrectException sequenceNotCorrectException){
                    exception = true;
                    sequenceNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException) {
                    exception = true;
                    matchingNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence1.getTextStructure().isEmpty()) {
                try {
                    sequence1.setMatching(tapPanelSequence1.getTextStructure());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    exception = true;
                    sizeNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException) {
                    exception = true;
                    matchingNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence2.getTextSequence().isEmpty()){
                try {
                    sequence2.setSequence(tapPanelSequence2.getTextSequence());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    exception = true;
                    sizeNotCorrectException.printStackTrace();
                } catch (SequenceNotCorrectException sequenceNotCorrectException){
                    exception = true;
                    sequenceNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException){
                    exception = true;
                    matchingNotCorrectException.printStackTrace();
                }
            }
            if (!tapPanelSequence2.getTextStructure().isEmpty()) {
                try {
                    sequence2.setMatching(tapPanelSequence2.getTextStructure());
                } catch (SizeNotCorrectException sizeNotCorrectException) {
                    exception = true;
                    sizeNotCorrectException.printStackTrace();
                } catch (MatchingNotCorrectException matchingNotCorrectException) {
                    exception = true;
                    matchingNotCorrectException.printStackTrace();
                }
            }

            ResultFrame f = null;
            if (exception == true){
                f = new ResultFrame(" Error : the program raises an exception.",300,true);
                f.setVisible(true);
            }
            else if (sequence1.isEmpty()){
                f = new ResultFrame(" Error : the first RNA strand is empty.",300,true);
                f.setVisible(true);
            }
            else if (sequence2.isEmpty()){
                f = new ResultFrame(" Error : the second RNA strand is empty.",300,true);
                f.setVisible(true);
            }
            else if (sequence1.size() >= sequence2.size()){
                if (sequence1.contains(sequence2)){
                    f = new ResultFrame(" The first RNA strand contains the second RNA strand.",330,false);
                    f.setVisible(true);
                }
                else {
                    f = new ResultFrame(" The first RNA strand does not contain the second RNA strand.",380,false);
                    f.setVisible(true);
                }
            }
            else {
                if (sequence2.contains(sequence1)) {
                    f = new ResultFrame(" The second RNAA strand contains the first RNA strand.",330,false);
                    f.setVisible(true);
                } else {
                    f = new ResultFrame(" The second RNA strand does not contain the first RNA strand.",380,false);
                    f.setVisible(true);
                }
            }
        }
    }

}
