public class Tree {
    Node root;
    public Tree(int keys ){
       this.root = new Node(keys);
    }
    public  void AddNodes(int keys) {
        Node current = root;
        while (current != null) {
            if (keys < current.getKeys()) {
                Node right = current.getRight();
            if (right==null){
                current.setLeft(new Node (keys));

            }
            else {
                Node left = current.getLeft();
                if (left==null){
                    current.setLeft(new Node (keys));
                }
                current=left;
            }
            }
        }
    }
}
