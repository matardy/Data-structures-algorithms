package Inclass.IB.CircularLinkedList;

public class CircularLinkedList <E>{
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
    // No longer need the head
    private Node<E> tail = null;
    private int size = 0;
    public CircularLinkedList(){}

    //acces methods
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public E first(){
        if(isEmpty()) return null;
        return tail.getNext().getData();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getData();
    }

    //update methods

    // Terminar de escribirlos. 


}
