package Inclass.IB.Nov26;

// Trabajo en clase,  Informe I:
// ---> https://aulasvirtuales.epn.edu.ec/mod/assign/view.php?id=3455764
// Grupo 1:




import java.util.Scanner;
public class Main {
    public static int[] miArreglo = new int[20]; // Declaracion del arreglo a usar
    public static int[][] miMatrix1 = new int[3][3]; //Declaracion de la matrix a usar
    public static int[][] miMatrix2 = new int[3][3]; //Declaracion de la matrix a usar
    public static Scanner sc = new Scanner(System.in);
    public static int CONT = 0;


    //-------------Algoritmos Unidimensionales---------------------------------
    public static void leerArreglo(int[] arreglo){
        for (int j : arreglo) {
            System.out.print(j + " ");
        }
    }

    public static int obtenerElementosActuales(int[] arreglo){
        int N = 0;
        for(int i : arreglo){
            if(i!=0){
                N += 1;
            }
        }
        return N;
    }

    public static void busca_secuencial_desordenado(int[] arreglo, int target){ // target -> valor buscado

        while(CONT<arreglo.length && target != arreglo[CONT]){
            CONT += 1;
        }
        if (CONT >= arreglo.length){
            System.out.println("El elemento " + target + " no se encontró en el arreglo.");
        }else{
            System.out.println("Se encontro el elemento " + target + " en la posicion " + CONT );
        }
    }

    public static int[] inserta_desordenado(int[] arreglo,int valorInsertar){
        int N = obtenerElementosActuales(arreglo);
        System.out.println(N);
        if(N < arreglo.length){
            arreglo[N] = valorInsertar;
        }else{
            System.out.println("no hay espacio en el arreglo.");

        }
        return arreglo ;
    }

    public static int[] elimina_desordenado(int [] arreglo, int valorEliminar){
        int N = obtenerElementosActuales(arreglo);
        while(CONT < N && valorEliminar != arreglo[CONT]){
            CONT += 1;
        }
        if(CONT >= arreglo.length){
            System.out.println("No se encontro el valor a eliminar");
        }else{
            for(int i = CONT ; i<=N; i++){
                arreglo[i] = arreglo[i+1];
            }
        }
        return arreglo;
    }

    public static int[] modifica_desordenado(int[] arreglo, int valor1, int valor2){
        int N = obtenerElementosActuales(arreglo);
        while(CONT < arreglo.length && valor1 != arreglo[CONT]){
            CONT += 1;
        }
        if(CONT >= arreglo.length){
            System.out.println("No se encontro el elemento a intercambiar");
        }else{
            arreglo[CONT] = valor2 ;
        }
        return arreglo;
    }

    //-------------------Algoritmos Bidimensioanles-----------------------------

    public static void mostrarBidimensional(int[][]M){
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[i].length; j++){
                System.out.print(M[i][j] + "  "); //without println
            }
            System.out.println();
        }
    }

    //---------------------------------------------------------------------------

    //Operaciones básicas en Arreglos Unidimensionales
    public static void OperacionesBasicasUnidimensionales(){

        //Escritura
        int input;
        int i=0;
        System.out.println();
        System.out.println("Ingrese valores al vector, presione -999 para terminar.");
        input = sc.nextInt();
        miArreglo[i] = input;
        while (input != -999){
            miArreglo[i] = input;
            input = sc.nextInt();
            i += 1;
        }

        //Lectura
        System.out.println("Lectura: ");
        System.out.println("Los elementos de mi arreglo son: ");
        leerArreglo(miArreglo);


        //Asignacion
        System.out.println();
        miArreglo = new int[]{1,2,3,4,5, 9,10,22,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println("Los nuevos elementos asignados son: ");
        leerArreglo(miArreglo);

        //Actualizacion
        int target;
        System.out.println();
        System.out.println("Ingrese el valor a buscar: ");
        target = sc.nextInt();
        busca_secuencial_desordenado(miArreglo, target);

        int valorInsertar;
        System.out.println("Ingrese el valor que desea insertar: ");
        valorInsertar = sc.nextInt();
        System.out.println("Ahora el arreglo es: ");
        leerArreglo(inserta_desordenado(miArreglo,valorInsertar));

        int valorEliminar;
        System.out.println();
        System.out.println("Ingrese el valor que desea eliminar");
        valorEliminar = sc.nextInt();
        System.out.println("Ahora el arreglo es: ");
        leerArreglo(elimina_desordenado(miArreglo,valorEliminar));

        int valor1, valor2;
        System.out.println();
        System.out.println("Ingrese el valor 1 a intercambiar: ");
        valor1 = sc.nextInt();
        System.out.println("Ingrese el valor por el cual se va a intercambiar: ");
        valor2 = sc.nextInt();
        System.out.println("Ahora el arreglo es: ");
        leerArreglo(modifica_desordenado(miArreglo,valor1,valor2));

    }

    public static void OperacionesBasicasBidimensionales(){
        miMatrix1 = new int[][]{{1,1,1} ,{2,2,2},{3,3,3}} ;
        miMatrix2 = new int[][]{{4,4,4} ,{5,5,5},{6,6,6}} ;
        System.out.println("Mis matrices son: ");
        System.out.println("Matrix 1: ");
        System.out.println();
        mostrarBidimensional(miMatrix1);
        System.out.println();
        System.out.println("Matrix 2: ");
        mostrarBidimensional(miMatrix2);

        int [][]miMatrix3 = new int[3][3];
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    miMatrix3[i][j] += miMatrix1[i][k] * miMatrix2[k][j];
                }
            }
        }
        System.out.println();
        System.out.println("La matrix resultante es: ");
        mostrarBidimensional(miMatrix3);

    }

    public static void OperacionesBasicasMultidimensionales(){
        int [][][]Matriz = new int[2][2][3];
        int sum = 0;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k =0; k<3; k++){
                    Matriz[i][j][k] = k*j ;
                }
            }
        }
        for(int k = 0; k<3; k++){
            sum += Matriz[0][1][k];
        }
        System.out.println("La matrix es: ");
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k =0; k<3; k++){
                    System.out.print(Matriz[i][j][k] + " ");

                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("La suma es: " + sum );
    }



    public static void main(String[] args){

        //Ej1
        OperacionesBasicasUnidimensionales();

        //Ej2
        System.out.println();
        OperacionesBasicasBidimensionales();

        //Ej3
        System.out.println();
        OperacionesBasicasMultidimensionales();

    }
}
