package Inclass.IB.Lists;

public class SinglyLinkedList<E> {
    // ---------- Nested class for Node ----------------
    private static class Node <E>{
        private E data;                         //
        private Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

        public E getData(){
            return this.data;
        }

        public Node<E> getNext(){
            return this.next;
        }

        public void setNext(Node<E> n){
            this.next = n ;
        }

    }
    // ---------- End of Nested class -------------------

    // instance variables of the SinglyLinkedList
    public Node<E> head = null;
    public Node<E> tail = null;
    private int size = 0 ;
    public SinglyLinkedList(){}

    // access methods
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public E first(){
        if(isEmpty()) return null;
        return head.getData();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getData();
    }

    //update methods

    public void addFirst(E e){
        this.head = new Node<>(e, this.head);
        if(size == 0)
            tail = head;
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e,null);
        if(isEmpty())
            this.head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public void insertNth(E e, int position){
        Node<E> node = new Node<>(e, null); // Create a new node


        if(head == null){
            // Lista vacia
            if(position != 0){
                return;
            } else { // posicion en cero, con head == null
                head = node;
            }
        }

        // Si se ingresa una posicion cero, es decir addFirst()
        if(head != null && position == 0){
            System.out.println("Hola!");
            node.setNext(head);
            head = node;
            return;
        }


        // Logica de insersion

        // Variables auxiliares para guardar el nodo actual y el previo
        Node<E> current  = head;
        Node<E> previous = null ;
        int i=0;

        while (i < position){
            // Llega hasta la posicion deseada y guarda el nodo anterior
            // y el nodo que se encuentra en la posicion a insertar
            previous = current;
            current = current.next;

            if(current == null){ // Si la lista se acaba
                break;
            }
            i++;
        }

        size++;
        node.setNext(current); // Linkea con el nodo que se encontraba en la posicion
        previous.setNext(node); // linkea al nodo de previo con el nuevo.

    }

    public void deleteNth(int position){

        if(head == null){ // controlar que head != null para realizar operaciones
            return;
        }
        if(head != null && position == 0){
            head = head.getNext();
            size--;
            if(size == 0)
                tail = null ;
            return;
        }
        // Variables auxiliares para guardar el nodo actual y el previo

        Node<E> current  = this.head;
        Node<E> previous = null ;
        int i=0;

        while (i < position){
            // Llega hasta la posicion deseada y guarda el nodo anterior
            // y el nodo que se encuentra en la posicion a insertar
            previous = current;
            current = current.next;

            if(current == null){ // Si la lista se acaba
                break;
            }
            i++;
        }

        size--;
        previous.setNext(current.next); // El anterior se linkea al siguiente del que se elimina


    }

    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getData();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer;
    }

    // display methodos

    public void show(){ // NO PUEDO MODIFICAR VARIABLES DE INSTANCIA!!
        Node<E> temp = head; // variable auxiliar para no modificar el head
        while(temp != null) {
            System.out.print(temp.getData());
            temp = temp.next;
            if(temp != null){ // Este head hace referencia al siguiente
                System.out.print(" --> ");
            }
        }
    }




    // ---- Main method -----
    public static void main(String[] args){

        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        myList.addFirst(2);
        myList.addLast(3);
        myList.addLast(6);
        myList.addLast(9);
        myList.addLast(1);
        System.out.println("Lista inicial!");
        myList.show();
        myList.insertNth(23,4);
        System.out.println("\nNueva lista: ");
        myList.show();
        System.out.println("\nTamanio: " + myList.size());
        myList.deleteNth(3);
        System.out.println("\nNueva lista: ");
        myList.show();
        System.out.println("\nTamanio: " + myList.size());


        //myList.show();





    }

}
