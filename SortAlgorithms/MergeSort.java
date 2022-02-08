package Inclass.IB.SortAlgorithms;

/**
 * Merge Sort se basa en la estrategia de divide y conquistaras.
 * Es un algoritmos recursivo.
 *
 * Ejemplo de la logica:
 *  1 2 3 4 5 6 7  8
 * |9|3|7|5|6|5|2|0|
 *  l           h
 *                    (1,8)
 *            /                 \
 *         (1,4)                 (5,8)
 *      /        \            /        \
 *    (1,2)     (3,4)       (5,6)      (7,8)
 *    /   \      /  \       /   \      /   \
 *  (1,1)(2,2) (3,3)(4,4)  (5,5)(6,6) (7,7)(8,8)
 *
 *
 *  Algoritmo Merge(A,B,m,n){
 *      i=1, j=1, k=1
 *      Mientras(i<=m y j<=n){
 *          si(A[i] < B[j]){
 *              C[k++] = A[i++]
 *          sino
 *              C[k++] = B[j++]
 *          }
 *      }
 *      para i hasta m hacer
 *          C[k++] = A[i]
 *      para j hasta n hacer
 *          C[k++] = B[i]
 *  }
 *
 *
 *
 *  Algoritmo MergeSort(l,h){
 *      Si( l < h ){
 *          mid = (l+h)/2
 *          MergeSort(l,h)
 *          MergeSort(mid+l, h)
 *          Merge(l,mid,h)
 *      }
 *  }
 */


public class MergeSort {
    // Hace merge de dos subarray de un array principal arr[]
    // Primer sub array: arr[1...m]
    // Secon sub array: arr[m+1...r]

    void merge(int arr[], int l, int m, int r){

        // Tamanio de los subarray
        int n1 = m - l + 1;
        int n2 = r - m;

        // Crea los array temportales
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Llena los array temportales
        for(int i=0; i<n1; ++i){
            L[i] = arr[l+i];
        }
        for(int j=0; j<n2; ++j){
            R[j] = arr[m + 1 + j];
        }

        // index de los sub array principales
        int i=0, j = 0;

        // index del array merge resultante
        int k = l;
        // Va comparando hasta que tengan la misma size
        // De esta forma el merge es ordenado
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Elementos restantes de L[]
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        //Elementos restantes de R;
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r){
        if(l < r){
            // Punto medio
            int m = l + (r-l)/2;

            // Ordena las ramas derecha y luego izquierda del arbol
            sort(arr,l,m);
            sort(arr, m+1 ,r);

            // merge de las ramas
            merge(arr,l,m,r);
        }
    }

    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + " ");

        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {12,11,13,5,6,7};
        print(arr);
        MergeSort algo = new MergeSort();
        algo.sort(arr, 0, arr.length - 1);
        print(arr);
    }


}
