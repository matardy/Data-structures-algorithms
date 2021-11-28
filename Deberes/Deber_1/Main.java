package epn.IB.Deberes.Deber_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flagEncendido;

        System.out.println("Probando la clase Automovil...");
        Automovil miAutomovil = new Automovil(23.3 , 10, 10000);
        System.out.println("El peso es: " + miAutomovil.obtenerPeso() + "\n" +
                            "Su altura es: " + miAutomovil.obtenerAltura() + "\n" +
                            "Su ancho es: " + miAutomovil.obtenerAncho());
        System.out.println("-----------------------");
        System.out.println("Interfaz de encedido, si desea encender su vehiculo digite 1: ");


        try {
            flagEncendido = sc.nextInt();
            if (flagEncendido == 1) {
                miAutomovil.encender();
            } else {
                if (flagEncendido == 0) {
                    miAutomovil.apagar();
                } else {
                    System.out.println("Opcion no valida!");
                }
            }
            System.out.println(miAutomovil.estado());
        }catch(InputMismatchException ime){ // Control de errores
            System.out.println("No puede ingresar letras!");
        }

    }
}
