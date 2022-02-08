package Inclass.IB.SortAlgorithms;

import Inclass.IB.Trees.BinarySearchTree;

/**
 * El algoritmo HeapSort hace uso del BinarySearchTree
 * Es por ello que en esta implementacion solo usaramos una implementacion
 * que hemos realizado anteriormente.
 */

public class HeapSort {
    public static void main(String[] args){
        int arr[] = {82,90,10,12,15,77,55,23};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for(int i=0; i<arr.length; i++){
            tree.insert(arr[i]);
        }
        MergeSort.print(arr);
        tree.printInorder(tree.root);
    }
}
