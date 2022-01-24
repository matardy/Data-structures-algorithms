package Inclass.IB.LinkedList;

public class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

    public static int countNodes(Node head){
        // assuming that head != null
        int counter = 0;
        while(head!= null){
            counter++;
            head = head.next;
        }
        return counter;
    }

    public static void main(String[] args){
        Node head = new Node(4);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(10);
        Node nodeE = new Node(2);
        head.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        System.out.println(countNodes(head));

    }
}
