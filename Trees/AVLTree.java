package Inclass.IB.Trees;

import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;

/*
Bibliografia:
https://www.baeldung.com/java-avl-trees (Buena explicacion)
https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
https://www.programiz.com/dsa/avl-tree
 */


public class AVLTree <E extends Comparable<E>> {

    //Sub clase para el nodo
    public static class Node<E>{
        public E key;
        int height;
        public Node<E> left, right;

        public Node(E item){
            this.key = item;
            this.height = 1;
            //this.left = this.right = null ;
        }
    }

    // Variables de instancia de AVLTree
    Node<E> root;
    AVLTree(){this.root = null;}

    public void insert(E key){
        this.root = insertElement(this.root , key);
    }
    // Funcion para obtener la altura de un arbol.
    public int height(Node<E> N){
        if(N == null)
            return 0;
        return N.height;
    }

    // Funcion para obtener el maximo de dos numeros
    public int max(int a, int b){
        return (a>b) ? a:b;
    }

    // Importante: Funcion para hacer una rotacion
    // a la derecha (Right rotate)

    public Node<E> rightRotate(Node<E> y ){
        Node<E> x = y.left;
        Node<E> T2 = x.right;  // sub arbol

        //Rotacion
        x.right = y;
        y.left = T2;

        // Actualiza las alturas debido a la rotacion
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Retorna la nueva raiz actualizada.
        return x;
    }

    // Importante: Funcion para hacer una rotacion a la izquierda
    // (Left Rotate)
    public Node<E> leftRotate(Node<E> x){
        Node<E> y = x.right;
        Node<E> T2 = y.left; // sub arbol izquierdo

        //Rotacion
        y.left = x;
        x.right = T2;

        // Actualiza las alturas en base a la rotacion
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // retorna la nueva raiz actualizada

        return y;
    }

    // Factor de equilibrio (Balance factor)
    public int getBalance(Node<E> N){
        if(N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public Node<E> insertElement(Node<E> root , E key){

        // 1. Insercion de BTS normal.
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key.compareTo(root.key) < 0){ // key < root.key
            root.left = insertElement(root.left, key);

        }else if(key.compareTo(root.key) > 0){ // key > root.key
            root.right = insertElement(root.right, key);
        }else{
            return root; // No se permiten datos duplicados.
        }

        // 2. Actualiza la altura del ancestro.
        //    root.right or root.left es donde se inserta
        //    root como tal es el ancestro del que se inserta.

        root.height = 1 + max(height(root.left), height(root.right));

        //3. Obtiene el factor de equilibrio del ancestro(root)
        //   y calcula si esta desiquilibrado o equilibrado

        int balance = getBalance(root);

        // Importante: Si el nodo esta desequilibrado (unblanced)
        // Tenemos 4 caso:


        if (balance > 1) {
            if (height(root.right.right) > height(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        } else if (balance < -1) {
            if(height(root.left.left) > height(root.left.right)){
                root = rightRotate(root);
            }else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        return root;
    }
    public void printTree(Node<E> root , String prefix){
        if(root == null) return;
        System.out.println(prefix + " -> " + root.key);
        printTree(root.left, "|" + prefix + " ");
        printTree(root.right,"|" + prefix + " ");
    }

    public static void main(String args[]){
         /* Exm:
              12
           /     \
          8       18
         /  \    /
         5  11  17
        /
       4                */
        System.out.println("Vamos a trabajar con el AVL: " );
        System.out.println("""
                              12
                           /     \\
                          8       18
                         /  \\    /  
                         5  11  17  
                        /
                       4 
                """);

        // insertion and declaration
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(12);
        tree.insert(8);
        tree.insert(5);
        tree.insert(11);
        tree.insert(17);
        tree.insert(4);

        tree.printTree(tree.root, "");

//        tree.insert(4);
//        tree.insert(17);
        //tree.insert(17);
        //tree.printTree(tree.root, "");
    }

}
