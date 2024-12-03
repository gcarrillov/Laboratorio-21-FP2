public class Espadachin extends Soldado {
    private double longitudEspada;

    public Espadachin(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.longitudEspada = longitudEspada;
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " crea un muro de escudos, aumentando su defensa en 3 puntos");
        this.defensa += 3; 
    }

    @Override
    public void finalizarAccionEspecial() {
        System.out.println(nombre + " baja el muro de escudos, regresando su defensa a la normalidad");
        this.defensa -= 3; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Longitud de Espada: %.2f", longitudEspada);
    }
}
