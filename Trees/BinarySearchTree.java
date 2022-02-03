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

    public void search(E key){
        Node<E> node = searchElement(this.root, key);
        System.out.println("   " + node.key);
        System.out.println(" /" + "    " + "\\");
        System.out.println(node.left.key + "     " + node.right.key);
    }
    public void delete(E key){
        this.root = deleteElement(this.root,key);
    }

    public Node<E> searchElement(Node<E> root, E key){

        if(root == null || root.key == key){
            return root;
        }

        if(root.key.compareTo(key) < 0){
            return searchElement(root.right, key);
        }
        return searchElement(root.left, key);

    }

    public Node<E> deleteElement(Node<E> root, E key) {

        // Caso base: si el arbol está vacio
        if (root == null) {
            return root;
        }

        // Si no está vacio recorremos el arbol
        if(key.compareTo(root.key) < 0){
            root.left = deleteElement(root.left, key);

        }else if(key.compareTo(root.key) > 0){
            root.right = deleteElement(root.right, key);


        // Si finalmente la llave es igual a la raiz, ese es el nodo a ser eliminado
        // Nos queda analizar si tiene o no tiene hijos.
        }else{
            // Nodo con uno o o ningun hijo
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // Nodo con dos hijos: Se tomara el sucesor en orden
            // sucesor en orden: el mas pequenio en el subarbol derecho.
            root.key = getMinValue(root.right); // Toma la posicion del que se elimina.

            // Borramos el sucesor en orden que cambiamos de lugar.
            root.right = deleteElement(root.right, root.key);
        }
        return root;

    }

    /*
    Esta funcion obtiene el valor minimo de un BTS, basicamente recorre
    hasta el final de la rama izquierda.
     */
    public E getMinValue(Node<E> auxRoot){
        E minv = auxRoot.key;
        while(auxRoot.left != null){
            minv = auxRoot.left.key;
            auxRoot = auxRoot.left;
        }
        return minv;
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

    public void printTree(Node<E> root , String prefix){
        if(root == null) return;
        System.out.println(prefix + " -> " + root.key);
        printTree(root.left, "|" + prefix + " ");
        printTree(root.right,"|" + prefix + " ");
    }

    public Node<E> getParent(Node<E> root, Node<E> son){

        if(root == son || root==null){
            return null ;
        }else{
            if(root.left==son || root.right==son){
                return root;
            }else{
                if(root.key.compareTo(son.key)<0){
                    return getParent(root.right,son);
                }else{
                    return getParent(root.left, son);
                }
            }
        }


    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        /* Exm:
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
                    /
                   75
       */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(75);

        tree.printInorder(tree.root);
        tree.search(30);
        tree.printTree(tree.root, "");
        System.out.println("Vamos a eliminar el 70: ");
        tree.delete(70);
        tree.printTree(tree.root, "");

    }
}
