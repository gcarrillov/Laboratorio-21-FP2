public abstract class Soldado {
    protected String nombre;
    protected int nivelVida;
    protected int ataque;
    protected int defensa;
    protected int fila;
    protected int columna;

    // Constructor
    public Soldado(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.fila = fila;
        this.columna = columna;
    }

    // Métodos comunes
    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void recibirAtaque(int dano) {
        this.nivelVida -= Math.max(0, dano - defensa);
    }

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    public abstract void accionEspecial(); // Método polimórfico

    public abstract void finalizarAccionEspecial(); // Restablece los efectos de la acción especial

    @Override
    public String toString() {
        return String.format("Soldado: %s, Vida: %d, Ataque: %d, Defensa: %d, Posición: (%d, %d)",
                              nombre, nivelVida, ataque, defensa, fila, columna);
    }
}
