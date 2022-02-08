package Inclass.IB.SortAlgorithms;


/**
 * Asi como MergeSort este algoritmo tambien se basa en Divide
 * y conquistaras. Elije un pivote y particiona el array
 * al rededor del pivote.
 *
 * En este caso trabajaremos con el caso que el pivote siempre sea el
 * ultimo elemento.
 *
 * Algoritmo partition(arr[], low, high){
 *     pivot = arr[high]
 *     i = (low - 1)
 *
 *     Para j = low hasta (high - 1) hacer
 *          Si (arr[j] < pivot){
 *              i++
 *              swap arr[i] y arr[j]
 *          }
 *     swap arr[i+1] y arr[high]
 *     retorna (i + 1)
 *
 * }
 *
 * Algoritmo quickSort(arr[], low, high){
 *     Si(low < high) {
 *         pi = partition(arr, low, high)
 *
 *         quickSort(arr, low, pi - 1)
 *         quickSort(arr, pi+1, high)
 *     }
 * }
 *
 * Ejemplo de logica:
 *
 * arr[] = {10, 80, 30, 90, 40, 50, 70}
 * Índices: 0 1 2 3 4 5 6
 *
 * bajo = 0, alto = 6, pivote = arr[h] = 70
 * Inicializar el índice del elemento más pequeño, i = -1
 *
 * Recorrer los elementos desde j = bajo hasta alto-1
 * j = 0 : Como arr[j] <= pivote, hacer i++ y swap(arr[i], arr[j])
 * i = 0
 * arr[] = {10, 80, 30, 90, 40, 50, 70} // No hay cambios porque i y j
 *                                      // son iguales
 *
 * j = 1 : Como arr[j] > pivote, no se hace nada
 * // No hay cambios en i y arr[]
 *
 * j = 2 : Como arr[j] <= pivote, hacer i++ y swap(arr[i], arr[j])
 * i = 1
 * arr[] = {10, 30, 80, 90, 40, 50, 70} // Intercambiamos 80 y 30
 *
 * j = 3 : Como arr[j] > pivote, no hacemos nada
 * // No hay cambios en i ni en arr[]
 *
 * j = 4 : Como arr[j] <= pivote, hacemos i++ y swap(arr[i], arr[j])
 * i = 2
 * arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 y 40 intercambiados
 * j = 5 : Como arr[j] <= pivote, haz i++ e intercambia arr[i] con arr[j]
 * i = 3
 * arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 y 50 intercambiados
 *
 * Salimos del bucle porque j es ahora igual a alto-1.
 * Finalmente colocamos el pivote en la posición correcta intercambiando
 * arr[i+1] y arr[high] (o pivote)
 * arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 y 70 intercambiados
 *
 * Ahora el 70 está en su lugar correcto. Todos los elementos menores que
 * 70 están antes de él y todos los elementos mayores que 70 están después
 * de él.
 *
 */


public class QuickSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    Esta funcion toma el ultimo elemento como pivote, posicion el pivote
    en su posicion correcta en el array ordenado y todoas los menores se va a la
    rama izquierda del arbol y mayores a la rama derecha.
     */
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        // index del elemento mas pequenio
        int i = (low - 1);

        for(int j=low; j <= high - 1; j++){

            if(arr[j] < pivot){
                i++;
                swap(arr, i,j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi -1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args){

        int[] arr = {10,2,3,5,1,5,23};
        int n = arr.length;
        quickSort(arr,0,n-1);

        MergeSort.print(arr); // solo para imprimir
    }

}
