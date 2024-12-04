public class Lancero extends Soldado {
    private double longitudLanza;

    // Constantes para los cambios en defensa y ataque durante la acción especial
    private static final int DEFENSA_EXTRA = 5;
    private static final int ATAQUE_DECREMENTO = 2;

    public Lancero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, double longitudLanza) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        
        // Validación para longitudLanza (asegurando que sea positiva)
        if (longitudLanza <= 0) {
            throw new IllegalArgumentException("La longitud de la lanza debe ser positiva.");
        }
        this.longitudLanza = longitudLanza;
    }

    // Método privado para ajustar defensa y ataque
    private void ajustarAtributos(int incrementoDefensa, int decrementoAtaque) {
        this.defensa += incrementoDefensa;
        this.ataque -= decrementoAtaque;
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " forma un schiltrom, aumentando su defensa en " + DEFENSA_EXTRA + " puntos y reduciendo su ataque en " + ATAQUE_DECREMENTO + " puntos.");
        ajustarAtributos(DEFENSA_EXTRA, ATAQUE_DECREMENTO);
    }

    @Override
    public void finalizarAccionEspecial() {
        System.out.println(nombre + " disuelve el schiltrom, regresando sus atributos a la normalidad.");
        ajustarAtributos(-DEFENSA_EXTRA, -ATAQUE_DECREMENTO);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Longitud de Lanza: %.2f", longitudLanza);
    }
}
