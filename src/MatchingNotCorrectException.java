import java.util.LinkedList;

public class MatchingNotCorrectException extends Exception {

    private String message;

    public MatchingNotCorrectException(String message){
        super(message);
    }

    public MatchingNotCorrectException(){
        super("The matching is not correct.");
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

    public static boolean MatchingIssue(String sequence, String matching){
        LinkedList<Character> file = new LinkedList<Character>();

        for (int i = 0; i < sequence.length(); i++) {
            if (matching.charAt(i) == '(') {
                file.add(0,sequence.charAt(i));
            } else if (matching.charAt(i) == ')') {
                switch (sequence.charAt(i)) {
                    case 'A':
                        if (file.getFirst() == 'U') {
                            file.removeFirst();
                        } else {
                            return true;
                        }
                        break;
                    case 'U':
                        if (file.getFirst() == 'A') {
                            file.removeFirst();
                        } else {
                            return true;
                        }
                        break;
                    case 'C':
                        if (file.getFirst() == 'G') {
                            file.removeFirst();
                        } else {
                            return true;
                        }
                        break;
                    case 'G':
                        if (file.getFirst() == 'C') {
                            file.removeFirst();
                        } else {
                            return true;
                        }
                        break;
                }
            }
        }

        if (file.isEmpty() == true){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String args[]){
        String sequence = "ACGUGCCACGAUUCAACGUGGCACAG";
        String matching = "--((((((((------))))))))--";
        System.out.println(MatchingNotCorrectException.MatchingIssue(sequence,matching));
    }

}
