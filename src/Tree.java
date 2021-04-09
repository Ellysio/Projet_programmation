public class Tree {

    // Attributes
    private String key;
    private Tree first_child;
    private Tree next_sibling;

    // Constructors
    public Tree(String key, Tree first_child, Tree next_sibling){
        this.key = key;
        this.first_child = first_child;
        this.next_sibling = next_sibling;
    }

    public Tree(String key){
        this(key,null,null);
    }

    public Tree(){ this(null,null,null); }

    public Tree getTreeFromMatching (String match){
        Tree T = new Tree();
        if (match !=null){
            for (char ch:match.toCharArray()){
                if (match.charAt(ch)=='(' || match.charAt(ch)==')' ){
                    System.out.println(this.key);
                }else if  (match.charAt(ch)== '-') {

                    System.out.println("");
                }

            }


        }
        return T ;
    }









    /** @return A boolean which is equal to one if the tree is null, zero otherwise */


    public void putFirstChild(Tree tree){
        this.first_child = tree;
    }

    public void putFirstChildIfAbsent(Tree tree){
        if (this.first_child == null){
            this.putFirstChild(tree);
        }
    }

    public void putNextSibling(Tree tree){
        this.next_sibling = tree;
    }

    public void putSiblingIfAbsent(Tree tree){
        if (this.next_sibling == null){
            this.putNextSibling(tree);
        }
    }

    public void replace(String key){
        this.key = key;
    }

    public void replace(String oldKey, String newKey){
        if (this.key == oldKey){
            this.key = newKey;
        }
    }

    public void deleteFirstChild(){
        this.first_child = null;
    }

    public void deleteNextSibling(){
        this.next_sibling = null;
    }

    /** @return The number of elements of the tree */
    public int count(){
        if (this.first_child == null && this.next_sibling == null){
            return 1;
        }
        else if (this.first_child == null){
            return (1 + this.next_sibling.count());
        }
        else if (this.next_sibling == null){
            return (1 + this.first_child.count());
        }
        else {
            return (1 + this.first_child.count() + this.next_sibling.count());
        }
    }

    /** @return The height of the tree (levels number) */
    public int height(){
        if (this.first_child == null && this.next_sibling == null){
            return 1;
        }
        else if (this.first_child == null){
            return this.next_sibling.height();
        }
        else if (this.next_sibling == null){
            return (1 + this.first_child.height());
        }
        else {
            return (Math.max(1 + this.first_child.height(),this.next_sibling.height()));
        }
    }

    public String getKey(){
        return this.key;
    }

    public Tree getFirstChild(){
        return this.first_child;
    }

    public Tree getNextSibling(){
        return this.next_sibling;
    }

    public void prefix(){
        System.out.print(this.key + " ");
        if (this.first_child != null) {
            this.first_child.prefix();
        }
        if (this.next_sibling != null) {
            this.next_sibling.prefix();
        }
    }

    public void suffix(){
        if (this.first_child != null) {
            this.first_child.suffix();
        }
        System.out.print(this.key + " ");
        if (this.next_sibling != null) {
            this.next_sibling.suffix();
        }
    }






    public static void main(String args[]){

        Tree c = new Tree("c",null,new Tree("d",new Tree("i", new Tree("j",null, new Tree ("k")),null),null));
        Tree b = new Tree("b", new Tree("e", null, new Tree ("f", null, new Tree ("g", null, new Tree ("h")))),c);
        Tree T = new Tree("a",b,null);
        T.prefix();
        System.out.println();
        T.suffix();
        System.out.println("\n" + "Taille : " + T.count());
        System.out.println("Profondeur : " + T.height());
        System.out.println();
        T.getTreeFromMatching(")(------()");






    }



}
