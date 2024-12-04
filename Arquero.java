public class Arquero extends Soldado {
    private int flechasDisponibles;
    private static final int BONUS_ATAQUE = 5;
    private boolean accionEspecialActiva;

    public Arquero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, int flechasDisponibles) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.flechasDisponibles = Math.max(0, flechasDisponibles); // Asegurarse de que no haya flechas negativas
        this.accionEspecialActiva = false; // Inicialmente la acción especial no está activa
    }

    @Override
    public void accionEspecial() {
        if (flechasDisponibles > 0) {
            System.out.println(getNombre() + " dispara una flecha, aumentando temporalmente su ataque en " + BONUS_ATAQUE + ".");
            modificarAtaque(BONUS_ATAQUE);
            flechasDisponibles--;
            accionEspecialActiva = true; // Indicar que la acción especial está activa
        } else {
            System.out.println(getNombre() + " no tiene flechas disponibles.");
        }
    }

    @Override
    public void finalizarAccionEspecial() {
        if (accionEspecialActiva) {
            System.out.println(getNombre() + " finaliza su ataque a distancia, regresando su ataque a la normalidad.");
            modificarAtaque(-BONUS_ATAQUE); // Reducir el ataque en el valor del bono
            accionEspecialActiva = false; // Desactivar la acción especial
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Flechas Disponibles: %d", flechasDisponibles);
    }

    // Método genérico para modificar el ataque
    private void modificarAtaque(int valor) {
        this.ataque += valor;
    }
}
