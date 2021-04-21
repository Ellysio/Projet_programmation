public class ARN {

    // Attributes
    private String sequence;
    private String matching;

    // Constructors
    public ARN(String sequence, String matching) throws SizeNotCorrectException, MatchingNotCorrectException {
        if (sequence.length() != matching.length()){
            throw new SizeNotCorrectException();
        }
        else if (MatchingNotCorrectException.MatchingIssue(matching)){
            throw new MatchingNotCorrectException();
        }
        else {
            this.sequence = sequence;
            this.matching = matching;
        }
    }

    public ARN(String sequence){
        this.sequence = sequence;
        this.matching = null;
    }

    // Methods
    /** @return A boolean which is equal to one if the tree is null, zero otherwise */
    public boolean isEmpty(){
        if (this.sequence == null && this.matching == null){
            return true;
        }
        else {
            return false;
        }
    }

    public String getSequence(){
        return this.sequence;
    }

    public String getMatching(){
        return this.matching;
    }

    public void setMatching(String matching) throws SizeNotCorrectException, MatchingNotCorrectException {
        if (this.sequence.length() != matching.length()){
            throw new SizeNotCorrectException();
        }
        else if (MatchingNotCorrectException.MatchingIssue(matching)){
            throw new MatchingNotCorrectException();
        }
        else {
            this.matching = matching;
        }
    }

    public boolean equalsSequence(ARN sequence2){
        if(this.sequence.equals(sequence2.getSequence())){
            return true;
        }
        else if (this.sequence.length() == sequence2.getSequence().length()){
            for (int i = 0; i < this.sequence.length(); i++){
                switch(this.sequence.charAt(i)){
                    case 'A':
                        if (sequence2.getSequence().charAt(i) != 'T'){
                            return false;
                        }
                        break;
                    case 'T':
                        if (sequence2.getSequence().charAt(i) != 'A'){
                            return false;
                        }
                        break;
                    case 'C':
                        if (sequence2.getSequence().charAt(i) != 'G'){
                            return false;
                        }
                        break;
                    case 'G':
                        if (sequence2.getSequence().charAt(i) != 'C'){
                            return false;
                        }
                        break;
                }
            }
            return true;
        }
        return false;
    }

    public boolean equalsMatching(ARN sequence2){
        if(this.matching.equals(sequence2.getMatching())){
            return true;
        }
        else if (this.sequence.length() == sequence2.getSequence().length()){
            int size = this.matching.length();
            for (int i = 0; i < size; i++) {
                switch(this.matching.charAt(i)) {
                    case '-':
                        if (sequence2.getMatching().charAt(size - i - 1) != '-') {
                            return false;
                        }
                        break;
                    case '(':
                        if (sequence2.getMatching().charAt(size - i - 1) != ')') {
                            return false;
                        }
                        break;
                    case ')':
                        if (sequence2.getMatching().charAt(size - i - 1) != '(') {
                            return false;
                        }
                        break;
                }
            }
            return true;
        }
        return false;
    }

/*    public boolean equalsMatching(ARN sequence2){
        if(this.matching.equals(sequence2.getMatching())){
            return true;
        }
        else if (this.sequence.length() == sequence2.getMatching().length()){

            for (int i = 0; i < this.matching.length(); i++){

            }
        }
        return false;
    }*/

    public boolean perfectlyEquals(ARN sequence2){
        return this.equals(sequence2) && this.sequence.equals(sequence2.getSequence());
    }

    @Override
    public String toString(){
        String result;
        result = "sequence : " + this.sequence + "\n";
        if (this.matching != null){
            result += "matching : " + this.matching;
        }
        return result;
    }

    public static void main(String args[]) throws SizeNotCorrectException, MatchingNotCorrectException {
        ARN seq1 = new ARN("ATCG","()--");
        // seq1.setMatching(")(------()");
        System.out.println(seq1);
        ARN seq2 = new ARN("TAGC","()--");
        System.out.println(seq1.equalsSequence(seq2));
        System.out.println(seq1.equalsMatching(seq2));

    }

}
