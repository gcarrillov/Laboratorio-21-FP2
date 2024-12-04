public abstract class Soldado {
    protected String nombre;
    protected int nivelVida;
    protected int ataque;
    protected int defensa;
    protected int fila;
    protected int columna;

    // Constructor con validaciones
    public Soldado(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        if (nivelVida < 0 || ataque < 0 || defensa < 0) {
            throw new IllegalArgumentException("Los valores de vida, ataque y defensa no pueden ser negativos.");
        }
        if (fila < 0 || columna < 0) {
            throw new IllegalArgumentException("Las posiciones de fila y columna no pueden ser negativas.");
        }
        
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.fila = fila;
        this.columna = columna;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    // Método para calcular el daño recibido, asegurándose de que no baje de 0
    private int calcularDanoRecibido(int dano) {
        return Math.max(0, dano - defensa);
    }

    // Método para recibir ataque, utilizando el método de cálculo de daño
    public void recibirAtaque(int dano) {
        int danoRecibido = calcularDanoRecibido(dano);
        this.nivelVida -= danoRecibido;
    }

    // Método para mover al soldado a una nueva posición en el mapa
    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    // Métodos abstractos para la acción especial y su finalización
    public abstract void accionEspecial();

    public abstract void finalizarAccionEspecial();

    // Método toString para representar al soldado como una cadena
    @Override
    public String toString() {
        return String.format("Soldado: %s, Vida: %d, Ataque: %d, Defensa: %d, Posicion: (%d, %d)",
                              nombre, nivelVida, ataque, defensa, fila, columna);
    }
}
