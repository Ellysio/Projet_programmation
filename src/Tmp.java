public class Tmp {

    public static void test(String matching) {
        System.out.println(matching);
        matching = matching.substring(1);
        if (!matching.isEmpty()) {
            Tmp.test(matching);
        }
        System.out.println("Test");
    }

    public static void secondaryStructureTreeRoot(String matching, Tree T){
        if (T.isEmpty()){
            StringBuffer matchingBuffer = new StringBuffer(matching);
            // System.out.println("Création d'un premier fils à la racine.");
            while (!matching.isEmpty()){
                Tree A = new Tree();
                T.putFirstChildIfAbsent(A);
                Tmp.secondaryStructureTree(matchingBuffer,A);
            }
        }
        else {
            StringBuffer matchingBuffer = new StringBuffer(matching);
            Tmp.secondaryStructureTree(matchingBuffer,T);
        }
    }

    public static void secondaryStructureTree(StringBuffer matching, Tree T){
        if (matching.charAt(0) == '-'){
            if (matching.length() > 1){
                if (matching.charAt(1) != ')'){
                    // System.out.println(matching);
                    Tree A = new Tree();
                    T.putNextSibling(A);
                    matching.deleteCharAt(0);
                    System.out.println("Traitement de '-' et le matching restant est : " + matching);
                    Tmp.secondaryStructureTree(matching,A);
                }
                else {
                    matching.deleteCharAt(0);
                }
            }
        }
        else if (matching.charAt(0) == '('){
            Tree A = new Tree();
            T.putFirstChild(A);
            matching.deleteCharAt(0);
            // System.out.println("Traitement de '(' et le matching restant est : " + matching);
            Tmp.secondaryStructureTree(matching,A);
            matching.deleteCharAt(0);
            // System.out.println("Le matching restant est : " + matching);
        }

    }



    public static void main(String args[]){

        // String seq = "--((((-((------)))))----";
        String seq = "(--)((--))";
        // Tmp.test(seq);
        Tree seqTree = new Tree();
        Tmp.secondaryStructureTreeRoot(seq,seqTree);
        System.out.println(seqTree.height());
        //System.out.println(matching);

    }

}
