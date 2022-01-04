package Inclass.IB.Examen;
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
FinFuncion


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
    public static void solve(int n, String A, String B, String C){
        if(n==1){
            System.out.println(A + " --> " + C);
        }else{
            solve(n-1, A,C,B);
            System.out.println(A + " --> " + C);
            solve(n-1, B, A, C);
        }
    }
    public static void main(String[] args){
        int numOfDiscs = 3;
        solve(numOfDiscs, "A", "B", "C");
    }
}
