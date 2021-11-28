package epn.IB.Deberes.Deber_1;

public class Automovil {
    private double altura;
    private double peso;
    private double ancho;
    private double largo;
    private int numeroDeRuedas;
    private String modelo;
    private boolean encedido; // Estado del automovil (Encedido o apagado)
    private boolean apagado;


    public Automovil(double altura, double ancho, double peso){
        this.altura = altura;
        this.ancho = ancho;
        this.peso = peso;
    }

    public double obtenerPeso(){
        return this.peso;
    }
    public double obtenerAltura(){
        return this.altura;
    }
    public double obtenerAncho(){
        return this.ancho;
    }
    public void encender(){
        this.encedido = true ;
        this.apagado = false;
    }
    public void apagar(){
        this.encedido = false;
        this.apagado = true;
    }
    public String estado(){
        return "Estado de su vehiculo: " + "\n" + "Encendido: " + this.encedido +
                "\t" + "Apagado: " + this.apagado;
    }


}
