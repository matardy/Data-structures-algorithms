package Inclass.IB.Nov23;


public class Main {
    public static void ArregloBidimensional(){
        //Resolucion de ejercicio hecho en clases
        int count = 1;
        int M[][] = new int[3][5]; // Se coloca la dimnesionn despues del tipo
        System.out.println(M.length); // De esa forma presenta la dimension de las filas
        System.out.println(M[0].length); // De esa forma se muestra las columnas por fila.

        //Llenado
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[i].length; j++){
                M[i][j] = count;
                count += 1;
            }
        }
        System.out.println("\n");
        //Mostrar
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[i].length; j++){
                System.out.print(M[i][j] + "  "); //without println
            }
            System.out.println();
        }



    }


    public static void main(String[] args){
        System.out.println("This its just java");
        ArregloBidimensional();
    }
}
