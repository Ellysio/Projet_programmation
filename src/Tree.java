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

    public Tree(){
        this(null,null,null);
    }

    // Methods
    /** @return A boolean which is equal to one if the tree is null, zero otherwise */
    public boolean isEmpty(){
        if (this.key == null && this.first_child == null && this.next_sibling == null){
            return true;
        }
        else {
            return false;
        }
    }

}
