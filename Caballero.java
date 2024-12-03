public class Caballero extends Soldado {
    private boolean montado;

    public Caballero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.montado = montado;
        ajustarAtributos(); 
    }

    private void ajustarAtributos() {
        if (montado) {
            this.ataque += 5;  
            this.defensa += 3; 
        } else {
            this.ataque -= 5;  
            this.defensa -= 3; 
        }
    }

    public void montar() {
        if (!montado) {
            montado = true;
            System.out.println(nombre + " monta su caballo, aumentando ataque y defensa");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya esta montado");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            System.out.println(nombre + " desmonta de su caballo, reduciendo ataque y defensa");
            ajustarAtributos();
        } else {
            System.out.println(nombre + " ya esta desmontado");
        }
    }

    @Override
    public void accionEspecial() {
        if (montado) {
            System.out.println(nombre + " realiza una envestida montado, aumentando temporalmente su ataque en 10");
            this.ataque += 10;
        } else {
            System.out.println(nombre + " realiza un doble ataque desmontado, aumentando temporalmente su ataque en 5");
            this.ataque += 5;
        }
    }

    @Override
    public void finalizarAccionEspecial() {
        if (montado) {
            System.out.println(nombre + " finaliza la envestida, regresando su ataque a la normalidad");
            this.ataque -= 10;
        } else {
            System.out.println(nombre + " finaliza su doble ataque, regresando su ataque a la normalidad");
            this.ataque -= 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Montado: %s", montado ? "Si" : "No");
    }
}
