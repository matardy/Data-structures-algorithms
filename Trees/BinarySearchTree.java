package Inclass.IB.Trees;

public class BinarySearchTree <E extends Comparable<E>>{

    // Sub clase para el Nodo.
    public static class Node<E>{
        public E key;
        public Node<E> left, right;

        public Node(E item){
            this.key = item;
            this.left = this.right = null;
        }


    }

    // Variables de instancia de BinarySearchTree
    Node<E> root;
    BinarySearchTree(){
        this.root = null;
    }


    // Metodos principales
    public void search(E key){
        Node<E> node = searchElement(this.root, key);
        System.out.println("   " + node.key);
        System.out.println(" /" + "    " + "\\");
        System.out.println(node.left.key + "     " + node.right.key);
    }
    public void delete(E key){
        this.root = deleteElement(this.root,key);
    }
    public void insert(E key){
        this.root = insertElement(this.root, key);
    }


    // Metodos principales: Main code.

    /**
     * Busca un nodo apartir de su llave.
     * @param root
     * @param key
     * @return Nodo buscado
     */
    public Node<E> searchElement(Node<E> root, E key){

        if(root == null || root.key == key){
            return root;
        }

        if(root.key.compareTo(key) < 0){
            return searchElement(root.right, key);
        }
        return searchElement(root.left, key);

    }

    /**
     * Elimina un nodo y reorganiza el arbol.
     * @param root
     * @param key
     * @return Arbol reoganizado (Devuelve el nodo root, de donde sale todo el arbol)
     */
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

    /**
     * Inserta un elemento basandose en el concepto de BTS.
     * @param root
     * @param key
     * @return De vuelve el arbol reorganizado
     */
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



    // Metodos secundarios:

    /**
     * Esta funcion obtiene el valor minimo de un BTS, basicamente recorre
     * hasta el final de la rama izquierda.
     * @param auxRoot Raiz de un arbol
     * @return Minimo de un arbol tipo <E>
     */
    public E getMinValue(Node<E> auxRoot){
        E minv = auxRoot.key;
        while(auxRoot.left != null){
            minv = auxRoot.left.key;
            auxRoot = auxRoot.left;
        }
        return minv;
    }

    /**
     * Imprime los nodos de un arbol de forma ascendente
     * @param root
     */
    public void printInorder(Node<E> root){
        if(root != null){
            printInorder(root.left);
            System.out.println(root.key);
            printInorder(root.right);
        }
    }

    /**
     * Imprime un arbol de forma jerarquica
     * @param root
     * @param prefix
     */
    public void printTree(Node<E> root , String prefix){
        if(root == null) return;
        System.out.println(prefix + " -> " + root.key);
        printTree(root.left, "|" + prefix + " ");
        printTree(root.right,"|" + prefix + " ");
    }

    /**
     * Obtiene el padre de un nodo
     * @param root
     * @param son
     * @return Nodo con el padre
     */
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
         /* Exm:
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
                    /
                   75*/
        System.out.println("Vamos a trabajar con el arbol: ");
        System.out.println("""
                  50
               /     \\
              30      70
             /  \\    /  \\
           20   40  60   80
                        /
                       75
                """);

        // Insersion y declaracion.
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(75);

        System.out.println("Imprimimos los nodos en orden: ");
        tree.printInorder(tree.root);
        System.out.println();

        System.out.println("Vamos a buscar el nodo con llave 30: ");
        tree.search(30);
        System.out.println();

        System.out.println("Imprimimos el arbol: ");
        tree.printTree(tree.root, "");
        System.out.println("Vamos a eliminar el 70: ");
        tree.delete(70);
        System.out.println("Imprimimos el arbol: ");
        tree.printTree(tree.root, "");
        System.out.println("Insertamos 90: ");
        tree.insert(90);
        System.out.println("Imprimimos el arbol: ");
        tree.printTree(tree.root, "");

    }
}
