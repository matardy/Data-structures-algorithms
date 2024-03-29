package Inclass.IB.Lists;

public class DoublyLinkedList <E>{
    // --- Nested Node Class -----
    private static class Node<E>{
        private E data;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            data = e;
            prev = p;
            next = n;
        }
        public E getData(){
            return data;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setPrev(Node<E> p){
            prev = p;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    // --------------------------------

    //Variables de instancia de la Doubly Linked List
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header, null);
        header.setNext(trailer);
    }

    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}

    public E first(){ // Usamos generics, E es un tipo que se define en el main
        if(isEmpty()) return null;
        return header.getNext().getData();
    }

    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getData();
    }

    // public update methodos
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // modifed methods

    public void insertNth(E e, int position){
        Node <E> node = new Node<>(e, null,null);

        if(header.next == null){
            // Lista vacia
            if(position != 0){
                return;
            } else { // posicion en cero, con head == null
                header.next = node;
            }
        }

        //No editar variables de instancia
        // Si se ingresa una posicion cero, es decir addFirst()
        if(header.next != null && position == 0){
            addBetween(e, header,header.getNext()); // Este metodo ya aumenta uno al tamanio

            return;
        }

        Node<E> current = header.next;

        int i = 0;
        while(i < position){
            current = current.next; // Nodo que se encuentra en la posicion a insertar
            i++;
        }

        if(position!=0){
            //Conecto el nuevo nodo
            node.setPrev(current.prev);
            node.setNext(current);
            //Actualizo los punteros
            current.prev.setNext(node);
            current.next.setPrev(node);
            size++;

        }


    }

    // metodos priv

    private void addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> newest = new Node<>(e, prev,next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node){
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return node.getData();
    }

    //Display

    public void show(){
        Node<E> temp = header.next;
        Node<E> finalTemp = trailer;
        while(temp != finalTemp) {
            System.out.print(temp.getData());
            temp = temp.next;
            if(temp != finalTemp){ // Este head hace referencia al siguiente
                System.out.print(" <--> ");
            }
        }
    }

    public static void main(String[] args){
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        myList.addFirst(2);
        myList.addLast(6);
        myList.addLast(3);
        myList.addLast(8);
        myList.show();
        System.out.println("\nSize: " + myList.size());
        myList.insertNth(24,2);
        System.out.println("Nueva lista: ");
        myList.show();
        System.out.println("\nSize: " + myList.size());
        myList.insertNth(7,0);
        System.out.println("Nueva lista: ");
        myList.show();
        System.out.println("\nSize: " + myList.size());




    }

}
