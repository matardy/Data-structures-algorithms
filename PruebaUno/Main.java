package Inclass.IB.PruebaUno;

/*
Nombre: Gutemberg S. Mendoza
Materia: Estructura de datos y algoritmos.
Prueba I del Primer Bimestre
Fecha: 3-Dic-2021

 */



public class Main {
    public static void printFormat(int[][] array){
        for(int i= array.length - 1; i>=0; i--){
            for(int j = 0 ; j<3; j++){
                System.out.println(array[i][j]);
            }
        }
    }


    public static void main(String[] args) {
        int [][]EDA = new int[][]{{1,5,9},{13,17,21},{25,29,33}};
        printFormat(EDA);

    }
}