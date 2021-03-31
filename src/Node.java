public class Node {

    // Attributes
    private String key;
    private Node left_child;
    private Node right_child;

    // Constructors
    public Node(String key, Node left_child, Node right_child){
        this.key = key;
        this.left_child = left_child;
        this.right_child = right_child;
    }

    public Node(String key){
        this(key,null,null);
    }



}
