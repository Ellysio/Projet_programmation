public class SizeNotCorrectException extends Exception {

    private String message;

    public SizeNotCorrectException(String message){
        super(message);
    }

    public SizeNotCorrectException(){
        super("The sequence size and the matching size are not equal.");
    }

}
