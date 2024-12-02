public class Lancero extends Soldado {
    private double longitudLanza;

    public Lancero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, double longitudLanza) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.longitudLanza = longitudLanza;
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " forma un schiltrom, aumentando su defensa en 5 puntos y reduciendo su ataque en 2.");
        this.defensa += 5; // Incrementa la defensa
        this.ataque -= 2;  // Penalización de ataque
    }

    @Override
    public void finalizarAccionEspecial() {
        System.out.println(nombre + " disuelve el schiltrom, regresando sus atributos a la normalidad.");
        this.defensa -= 5; // Reversión del incremento
        this.ataque += 2;  // Reversión de la penalización
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Longitud de Lanza: %.2f", longitudLanza);
    }
}
