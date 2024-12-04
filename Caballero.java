public class Caballero extends Soldado {
    private boolean montado;

    public Caballero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.montado = montado;
        ajustarAtributos();
    }

    // Método privado para modificar el ataque y defensa
    private void modificarAtributos(int incrementoAtaque, int incrementoDefensa) {
        this.ataque += incrementoAtaque;
        this.defensa += incrementoDefensa;
    }

    // Ajusta atributos dependiendo si está montado o no
    private void ajustarAtributos() {
        if (montado) {
            modificarAtributos(5, 3);  // Aumenta ataque y defensa
        } else {
            modificarAtributos(-5, -3);  // Reduce ataque y defensa
        }
    }

    public void montar() {
        if (!montado) {
            montado = true;
            System.out.println(nombre + " monta su caballo, aumentando su ataque y defensa.");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya está montado.");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            System.out.println(nombre + " desmonta de su caballo, reduciendo su ataque y defensa.");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya está desmontado.");
        }
    }

    @Override
    public void accionEspecial() {
        if (montado) {
            System.out.println(nombre + " realiza una envestida montado, aumentando temporalmente su ataque en 10 puntos.");
            modificarAtributos(10, 0);
        } else {
            System.out.println(nombre + " realiza un doble ataque desmontado, aumentando temporalmente su ataque en 5 puntos.");
            modificarAtributos(5, 0);
        }
    }

    @Override
    public void finalizarAccionEspecial() {
        if (montado) {
            System.out.println(nombre + " finaliza la envestida, regresando su ataque a la normalidad.");
            modificarAtributos(-10, 0);
        } else {
            System.out.println(nombre + " finaliza su doble ataque, regresando su ataque a la normalidad.");
            modificarAtributos(-5, 0);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Montado: %s", montado ? "Sí" : "No");
    }
}
