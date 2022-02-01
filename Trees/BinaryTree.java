package Inclass.IB.Trees;

public class BinaryTree<E>  {
    private static class Node <E>{
        E key;
        Node<E> left, right;

        public Node(E item){
            this.key = item;
            this.left = this.right = null;

        }
    }
    // Root of Binary Tree
    Node<E> root;
    BinaryTree(E key){
        this.root  = new Node<E>(key);
    }
    BinaryTree(){
        this.root = null;
    }


    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new Node(1);
        /*
                1
             /      \
         null       null
         */
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */


        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null

         */
    }
}
