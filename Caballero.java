public class Caballero extends Soldado {
    private boolean montado;

    public Caballero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.montado = montado;
        ajustarAtributos(); // Ajusta los atributos según el estado inicial
    }

    private void ajustarAtributos() {
        if (montado) {
            this.ataque += 5;  // Incremento de ataque al montar
            this.defensa += 3; // Incremento de defensa al montar
        } else {
            this.ataque -= 5;  // Reducción de ataque al desmontar
            this.defensa -= 3; // Reducción de defensa al desmontar
        }
    }

    public void montar() {
        if (!montado) {
            montado = true;
            System.out.println(nombre + " monta su caballo, aumentando ataque y defensa.");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya está montado.");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            System.out.println(nombre + " desmonta de su caballo, reduciendo ataque y defensa.");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya está desmontado.");
        }
    }

    @Override
    public void accionEspecial() {
        if (montado) {
            System.out.println(nombre + " realiza una envestida montado, aumentando temporalmente su ataque en 10.");
            this.ataque += 10;
        } else {
            System.out.println(nombre + " realiza un doble ataque desmontado, aumentando temporalmente su ataque en 5.");
            this.ataque += 5;
        }
    }

    @Override
    public void finalizarAccionEspecial() {
        if (montado) {
            System.out.println(nombre + " finaliza la envestida, regresando su ataque a la normalidad.");
            this.ataque -= 10;
        } else {
            System.out.println(nombre + " finaliza su doble ataque, regresando su ataque a la normalidad.");
            this.ataque -= 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Montado: %s", montado ? "Sí" : "No");
    }
}