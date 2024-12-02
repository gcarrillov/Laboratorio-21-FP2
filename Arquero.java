public class Arquero extends Soldado {
    private int flechasDisponibles;

    public Arquero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, int flechasDisponibles) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.flechasDisponibles = flechasDisponibles;
    }

    @Override
    public void accionEspecial() {
        if (flechasDisponibles > 0) {
            System.out.println(nombre + " dispara una flecha, aumentando temporalmente su ataque en 5.");
            this.ataque += 5; 
            flechasDisponibles--;
        } else {
            System.out.println(nombre + " no tiene flechas disponibles.");
        }
    }

    @Override
    public void finalizarAccionEspecial() {
        System.out.println(nombre + " finaliza su ataque a distancia, regresando su ataque a la normalidad.");
        this.ataque -= 5; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Flechas Disponibles: %d", flechasDisponibles);
    }
}
