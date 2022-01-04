package Inclass.IB.Examen;

// Ej5
/*
Algoritmo
Funcion TowerOfHanoi ( n, A, B, C )
	Si n=1 Entonces
		escribir A , " --> " , C
	SiNo
		TowerOfHanoi(n-1, A, C, B)
		escribir A, " --> " , C
		TowerOfHanoi(n-1, B,A,C)
	Fin Si
FinFuncion.


Algoritmo TowerOfHanoi_Recursivo
	definir numOfDiscs como entero
	definir A,B,C Como Caracter
	A = "A"
	B = "B"
	C = "C"
	numOfDiscs = 3
	TowerOfHanoi(numOfDiscs, A, B, C)

FinAlgoritmo
 */
public class Main {

    //Ej 5
    public static void solve(int n, String A, String B, String C){
        if(n==1){
            System.out.println(A + " --> " + C);
        }else{
            solve(n-1, A,C,B);
            System.out.println(A + " --> " + C);
            solve(n-1, B, A, C);
        }
    }

    public static void pregunta1a(){
        int  arreglo[][];
        int i;
        int j;
        arreglo  = new int[4][3];
        for( i=1; i<=4; i++){
            for(j=1; j<=4; j++){
                System.out.print(arreglo[i-1][j-1]);
            }
            System.out.println();
        }
    }

    public static void pregunta1b(){
        int arreglo[][];
        int i;
        int j;
        int suma;
        suma = 0;
        arreglo = new int[4][3];
        for(i=0; i<=4; i++){
            for(j=0; j<=4; j++){
                System.out.println(arreglo[i-1][j-1]);
            }
        }
        for(i=1; i<=4; i++){
            suma = suma + arreglo[i-1][1];
        }
        System.out.println(suma);
    }


    public static void main(String[] args){
        int numOfDiscs = 3;
        solve(numOfDiscs, "A", "B", "C");
    }
}
