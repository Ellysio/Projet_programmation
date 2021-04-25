public class ARN {

    // Attributes
    private String sequence;
    private String matching;

    // Constructors
    public ARN(String sequence, String matching) throws SizeNotCorrectException, SequenceNotCorrectException, MatchingNotCorrectException {
        if (sequence.length() != matching.length()){
            throw new SizeNotCorrectException();
        }
        else if (SequenceNotCorrectException.SequenceIssue(sequence)){
            throw new SequenceNotCorrectException();
        }
        else if (MatchingNotCorrectException.MatchingIssue(matching)){
            throw new MatchingNotCorrectException();
        }
        else if (MatchingNotCorrectException.MatchingIssue(sequence, matching)){
            throw new MatchingNotCorrectException();
        }
        else {
            this.sequence = sequence;
            this.matching = matching;
        }
    }

    public ARN(String sequence) throws SequenceNotCorrectException {
        if (SequenceNotCorrectException.SequenceIssue(sequence)){
            throw new SequenceNotCorrectException();
        }
        else {
            this.sequence = sequence;
            this.matching = null;
        }
    }

    public ARN(){
        this.sequence = null;
        this.matching = null;
    }

    // Methods
    /** @return A boolean which is equal to one if the sequence is null, zero otherwise */
    public boolean isEmpty(){
        if (this.sequence == null && this.matching == null){
            return true;
        }
        else {
            return false;
        }
    }

    public void setSequence(String sequence) throws SizeNotCorrectException, SequenceNotCorrectException, MatchingNotCorrectException {
        if (this.matching != null) {
            if (this.matching.length() != sequence.length()) {
                throw new SizeNotCorrectException();
            }
            else if (MatchingNotCorrectException.MatchingIssue(sequence, this.matching)){
                throw new MatchingNotCorrectException();
            }
        }
        if (SequenceNotCorrectException.SequenceIssue(sequence)){
            throw new SequenceNotCorrectException();
        }
        this.sequence = sequence;
    }

    public void setMatching(String matching) throws SizeNotCorrectException, MatchingNotCorrectException {
        if (this.sequence != null){
            if (this.sequence.length() != matching.length()){
                throw new SizeNotCorrectException();
            }
            else if (MatchingNotCorrectException.MatchingIssue(this.sequence, matching)){
                throw new MatchingNotCorrectException();
            }
        }
        if (MatchingNotCorrectException.MatchingIssue(matching)){
            throw new MatchingNotCorrectException();
        }
        else{
            this.matching = matching;
        }
    }

    public void removeSequence(){
        this.sequence = null;
    }

    public void removeMatching(){
        this.matching = null;
    }

    public void clear(){
        this.sequence = null;
        this.matching = null;
    }

    public int size(){
        if (this.sequence != null){
            return this.sequence.length();
        }
        else if (this.matching != null){
            return this.matching.length();
        }
        else {
            return 0;
        }
    }

    public boolean equalsSequence(ARN sequence2){
        if(this.sequence.equals(sequence2.getSequence())){
            return true;
        }
        else if (this.size() == sequence2.size()){
            for (int i = 0; i < this.size(); i++){
                switch(this.sequence.charAt(i)){
                    case 'A':
                        if (sequence2.getSequence().charAt(i) != 'U'){
                            return false;
                        }
                        break;
                    case 'U':
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
        else if (this.size() == sequence2.size()){
            int size = this.size();
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

    public boolean equals(ARN sequence2){
        if ((this.sequence != null && sequence2.getSequence() != null) && (this.matching != null && sequence2.getMatching() != null)){
            return (this.equalsSequence(sequence2) && this.equalsMatching(sequence2));
        }
        else if (this.sequence != null && sequence2.getSequence() != null){
            return this.equalsSequence(sequence2);
        }
        else if (this.matching != null && sequence2.getMatching() != null){
            return this.equalsMatching(sequence2);
        }
        else {
            return false;
        }
    }

    public boolean containsSequence(String sequence){
        int size = sequence.length();
        for (int i = 0; i < this.size() - size + 1; i++){
            if (this.sequence.substring(i,i+size).equals(sequence)){
                return true;
            }
        }
        return false;
    }

    public boolean containsMatching(String matching){
        int size = matching.length();
        for (int i = 0; i < this.size() - size + 1; i++){
            if (this.matching.substring(i,i+size).equals(matching)){
                return true;
            }
        }
        return false;
    }

    public boolean contains(ARN sequence2){
        if (this.sequence != null && sequence2.getSequence() != null && this.matching != null && sequence2.getMatching() != null){
            int size = sequence2.size();
            for (int i = 0; i < this.size() - size + 1; i++){
                if (this.sequence.substring(i,i+size).equals(sequence2.getSequence()) && this.matching.substring(i,i+size).equals(sequence2.getMatching())){
                    return true;
                }
            }
            return false;
        }
        else if (this.matching != null && sequence2.getMatching() != null){
            return this.containsMatching(sequence2.getMatching());
        }
        else if (this.sequence != null && sequence2.getSequence() != null){
            return this.containsSequence(sequence2.getSequence());
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

    @Override
    public String toString(){
        String result = new String();
        if (this.sequence != null){
            result += "sequence : " + this.sequence + "\n";
        }
        if (this.matching != null){
            result += "matching : " + this.matching;
        }
        return result;
    }

    public static void main(String args[]) throws SizeNotCorrectException, SequenceNotCorrectException, MatchingNotCorrectException {
        ARN seq1 = new ARN("AUUGGGG");
        seq1.setMatching("----(-)");
        //seq1.setSequence("ATCGAAA");
        System.out.println(seq1);
        ARN seq2 = new ARN();
        seq2.setMatching("----(-)");
        System.out.println("Contient ? " + seq1.contains(seq2));
/*        System.out.println(seq1.equalsSequence(seq2));
        System.out.println(seq1.equalsMatching(seq2));
        System.out.println(seq1.equals(seq2));*/
    }

}
