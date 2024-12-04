public class Espadachin extends Soldado {
    private double longitudEspada;
    
    // Definir una constante para la mejora de la defensa
    private static final int DEFENSA_EXTRA = 3;

    public Espadachin(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        
        // Validación simple para longitudEspada
        if (longitudEspada <= 0) {
            throw new IllegalArgumentException("La longitud de la espada debe ser positiva.");
        }
        this.longitudEspada = longitudEspada;
    }

    // Método privado para ajustar la defensa
    private void ajustarDefensa(int cantidad) {
        this.defensa += cantidad;
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " crea un muro de escudos, aumentando su defensa en " + DEFENSA_EXTRA + " puntos.");
        ajustarDefensa(DEFENSA_EXTRA);
    }

    @Override
    public void finalizarAccionEspecial() {
        System.out.println(nombre + " baja el muro de escudos, regresando su defensa a la normalidad.");
        ajustarDefensa(-DEFENSA_EXTRA);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Longitud de Espada: %.2f", longitudEspada);
    }
}
