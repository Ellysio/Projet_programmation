public class SequenceNotCorrectException extends Exception {

    private String message;

    public SequenceNotCorrectException(String message){
        super(message);
    }

    public SequenceNotCorrectException(){
        super("The syntax of sequence is not correct.");
    }

    public static boolean SequenceIssue(String sequence){
        char[] sequenceArray = sequence.toCharArray();
        for (char nucleotid : sequenceArray){
            if (nucleotid != 'A' && nucleotid != 'U' && nucleotid != 'C' && nucleotid != 'G' && nucleotid != '-'){
                return true;
            }
        }
        return false;
    }

}
