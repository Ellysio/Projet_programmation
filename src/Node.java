public class Node  {
  private int keys;
  Node  left;
  Node  right;

    public Node (int keys, Node  left, Node  right) {
     this(keys);
     this.left=left;
     this.right=right;



    }

    public Node(int keys) {
        this.keys=keys;
    }

    public  int getKeys(){
        return  keys;
    }
    public Node getLeft(){
        return left;
    }
    public Node  getRight(){
        return  right;
    }
    public void setLeft(Node left ){
        this.left=left;
    }
     public void setRight(Node right){
        this.right=right;
     }


}
