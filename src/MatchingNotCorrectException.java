public class MatchingNotCorrectException extends Exception {

    private String message;

    public MatchingNotCorrectException(String message){
        super(message);
    }

    public MatchingNotCorrectException(){
        super("The syntax of matching is not correct.");
    }

    public static boolean MatchingIssue(String matching){
        char[] matchArray = matching.toCharArray();
        int availableClosingParenthesis = 0;

        for (char value : matchArray){
            if (value == '('){
                availableClosingParenthesis += 1;
            }
            else if (value == ')'){
                if (availableClosingParenthesis > 0){
                    availableClosingParenthesis -= 1;
                }
                else {
                    return true;
                }
            }
            else if (value != '-'){
                return true;
            }
        }

        if (availableClosingParenthesis > 0){
            return true;
        }
        else {
            return false;
        }
    }

}
