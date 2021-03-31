public class Tree {

    // Attributes
    private String key;
    private Tree left_child;
    private Tree right_child;

    // Constructors
    public Tree(String key, Tree left_child, Tree right_child){
        this.key = key;
        this.left_child = left_child;
        this.right_child = right_child;
    }

    public Tree(String key){
        this(key,null,null);
    }

    public Tree(){
        this(null,null,null);
    }

    // Methods
    public boolean isEmpty(){
        if (this == null){
            return true;
        }
        else {
            return false;
        }
    }

    public void putLeft(Tree tree){
        this.left_child = tree;
    }

    public void putLeftIfAbsent(Tree tree){
        if (this.left_child == null){
            this.putLeft(tree);
        }
    }

    public void putRight(Tree tree){
        this.right_child = tree;
    }

    public void putRightIfAbsent(Tree tree){
        if (this.left_child == null){
            this.putRight(tree);
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

    public void deleteLeft(){
        this.left_child = null;
    }

    public void rightLeft(){
        this.right_child = null;
    }

    // public int height();
    // public boolean containsKey(String key);





    public String getKey(){
        return this.key;
    }

    public Tree getLeftChild(){
        return this.left_child;
    }

    public Tree getRightChild(){
        return this.right_child;
    }

    public void prefix(){
        System.out.print(this.key + " ");
        if (this.left_child != null) {
            this.left_child.prefix();
        }
        if (this.right_child != null) {
            this.right_child.prefix();
        }
    }

    public void infix(){
        if (this.left_child != null) {
            this.left_child.infix();
        }
        System.out.print(this.key + " ");
        if (this.right_child != null) {
            this.right_child.infix();
        }
    }

    public void suffix(){
        if (this.left_child != null) {
            this.left_child.suffix();
        }
        if (this.right_child != null) {
            this.right_child.suffix();
        }
        System.out.print(this.key + " ");
    }

    public static void main(String[] args) {
    Tree n1 = new Tree("n1",
              new Tree("n2", new Tree("n4"), new Tree("n5", new Tree("n7"), new Tree("n8"))),
              new Tree("n3", new Tree("n6",null, new Tree("n9", new Tree("n10"),new Tree("n11"))),null));
    System.out.println(n1.getLeftChild().getLeftChild().getKey());
    System.out.println();
    n1.prefix();
    System.out.println();
    n1.suffix();
    System.out.println();
    n1.infix();
    System.out.println();
    Tree n3 = null;
    System.out.println(n3);

    }

}
