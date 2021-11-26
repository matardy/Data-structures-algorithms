package Inclass.IB.Nov19;





public class Main {
    public static void declarar(){
        // Declarative
        String names[];
        // Create
        names = new String[5];
        //Initiate
        names = new String[]{"carlos", "pepe", "daniel", "Lucas", "stev"};
        for(int i=0; i<names.length; i++){
            System.out.println(names[i]);
        }
    }

    public static void BusquedaSecuencial(){
        //Busqueda secuencial en un arreglo desordenado
        int flag = 8;
        int numbers[] = new int[]{1,5,3,4,2,31,1};
        int i=0;
        while (i < numbers.length && flag != numbers[i]){
            i = i + 1;
        }
        if (i > numbers.length-1){ // i empieza desde cero, por ende a la dimension hay que bajarle.
            System.out.println("El valor " + flag + " no se encuentra en el arreglo.");
        }else{
            System.out.println("El valor " + flag + " se encuentra en la posicion " + i + ".");
        }
    }

    public static void main(String[] args) {

        BusquedaSecuencial();
    }
}
