package Inclass.IB.Trees;

public class BinarySearchTree <E extends Comparable<E>>{


    public static class Node<E>{
        public E key;
        public Node<E> left, right;

        public Node(E item){
            this.key = item;
            this.left = this.right = null;
        }


    }
    Node<E> root;

    BinarySearchTree(){
        this.root = null;
    }

    // Retorna un Nodo
    public Node<E> search(Node<E> root, E key){

        if(root == null || root.key == key){
            return root;
        }

        if(root.key.compareTo(key) < 0){
            return search(root.right, key);
        }
        return search(root.left, key);

    }

    public void insert(E key){
        this.root = insertElement(this.root, key);
    }

    public Node<E> insertElement(Node<E> root , E key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key.compareTo(root.key) < 0){ // key < root.key
            root.left = insertElement(root.left, key);

        }else if(key.compareTo(root.key) > 0){ // key > root.key
            root.right = insertElement(root.right, key);
        }
        return root;
    }

    public void printInorder(Node<E> root){
        if(root != null){
            printInorder(root.left);
            System.out.println(root.key);
            printInorder(root.right);
        }
    }

    public void getParent(Node<E> node, E val, E parent){
        if (node == null){
            return;
        }
        if(node.key == val){
            System.out.println(parent);
        }else{
            getParent(node.left, val, node.key);
            getParent(node.right,val,node.key);
        }

    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        /* Exm:
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.printInorder(tree.root);
        System.out.println("Vamos a buscar el valor 30: ");
        try{
            Node<Integer> node = tree.search(tree.root, 30);
            System.out.println("El valor 30 si se encuentre en el valor");
            System.out.println("  "+ node.key);

            System.out.println("/" + "    " + "\\");
            if(node.left.key == null && node.right.key ==null){
                System.out.println("null" + "    " + "null");
            }
            System.out.println(node.left.key + "    " + node.right.key);
        }catch(NullPointerException npe){
            System.out.println("El valor no se encuentra en el arbol.");
        }


    }
}
