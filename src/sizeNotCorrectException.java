public class sizeNotCorrectException extends Exception {

    private String message;

    public sizeNotCorrectException(String message){
        super(message);
    }

    public sizeNotCorrectException(){
        super("The size of the sequence and the matching is not equal.");
    }

}
