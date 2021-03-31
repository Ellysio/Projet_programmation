import java.util.LinkedList;
import java.util.Queue;

public class Arbre {
    Node root;

    public Arbre() {
        this.root = null;
    }

    public Arbre(int key) {
        root = new Node(key);
    }

    // affichage de l'arbre :
    void printNodes(Node root, int start, int end) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node current = null; // le noeud en cours
        int level = 0;// le niveau ou on est dans l'arbre
        // parcourir l'arbre
        while (!queue.isEmpty()) {// while list is not empty
            level++;
            int size = queue.size();
            while (size != 0) {
                current = queue.peek(); // on récupére le premier élément de la liste Queue sans le supprimer et on le stocke dans le noeud current
                queue.poll(); // on le supprime dans ce cas
                if (level >= start && level <= end) {
                    System.out.print(current.key + " ");
                }
                if (current.left != null) {
                    queue.add(current.left);
                    // on ajoute le fils droit
                    queue.add(current.right);
                    size--;
                }// end of while
                if (level >= start && level <= end) {
                    System.out.print("\n");


                }

            }


        }
    }
}
