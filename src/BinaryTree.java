public class BinaryTree {

    // Attributes
    private String key;
    private BinaryTree left_child;
    private BinaryTree right_child;

    // Constructors
    public BinaryTree(String key, BinaryTree left_child, BinaryTree right_child){
        this.key = key;
        this.left_child = left_child;
        this.right_child = right_child;
    }

    public BinaryTree(String key){
        this(key,null,null);
    }

    public BinaryTree(){
        this(null,null,null);
    }

    // Methods
    /** @return A boolean which is equal to one if the tree is null, zero otherwise */
    public boolean isEmpty(){
        if (this == null){
            return true;
        }
        else {
            return false;
        }
    }

    public void putLeft(BinaryTree tree){
        this.left_child = tree;
    }

    public void putLeftIfAbsent(BinaryTree tree){
        if (this.left_child == null){
            this.putLeft(tree);
        }
    }

    public void putRight(BinaryTree tree){
        this.right_child = tree;
    }

    public void putRightIfAbsent(BinaryTree tree){
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

    public void deleteRight(){
        this.right_child = null;
    }

    /** @return The height of the tree (levels number) */
    public int height(){
        System.out.println(this.key);
        if (this.left_child == null && this.right_child == null){
            return 1;
        }
        else if (this.left_child == null){
            return (1 + this.right_child.height());
        }
        else if (this.right_child == null){
            return (1 + this.left_child.height());
        }
        else {
            return (1 + Math.max(this.left_child.height(),this.right_child.height()));
        }
    }

    public String getKey(){
        return this.key;
    }

    public BinaryTree getLeftChild(){
        return this.left_child;
    }

    public BinaryTree getRightChild(){
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
    BinaryTree n1 = new BinaryTree("n1",
              new BinaryTree("n2", new BinaryTree("n4"), new BinaryTree("n5", new BinaryTree("n7"), new BinaryTree("n8"))),
              new BinaryTree("n3", new BinaryTree("n6",null, new BinaryTree("n9", new BinaryTree("n10"),new BinaryTree("n11"))),null));
    System.out.println(n1.getLeftChild().getLeftChild().getKey());
    System.out.println();
    n1.prefix();
    System.out.println();
    n1.suffix();
    System.out.println();
    n1.infix();
    System.out.println();
    BinaryTree n3 = null;
    System.out.println(n3);
    System.out.println("profondeur = " + n1.height());

    }

}
