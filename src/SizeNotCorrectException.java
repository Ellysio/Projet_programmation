public class SizeNotCorrectException extends Exception {

    private String message;

    public SizeNotCorrectException(String message){
        super(message);
    }

    public SizeNotCorrectException(){
        super("The size of the sequence and the matching is not equal.");
    }

}
