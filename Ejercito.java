import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercito {
    private String nombreReino;
    private List<Soldado> soldados;

    // Constructor
    public Ejercito(String nombreReino, boolean usarArrayList) {
        this.nombreReino = nombreReino;
        if (usarArrayList) {
            soldados = new ArrayList<>();
        } else {
            soldados = new ArrayList<>(10); // Simula un arreglo estándar
        }
    }

    // Método para agregar soldados al ejército
    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    // Generación automática de soldados
    public void generarSoldados(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String tipo = switch (random.nextInt(4)) {
                case 0 -> "Espadachin";
                case 1 -> "Arquero";
                case 2 -> "Caballero";
                default -> "Lancero";
            };
            Soldado nuevoSoldado = crearSoldado(tipo, i, random);
            agregarSoldado(nuevoSoldado);
        }
    }

    // Crear soldados según el tipo
    private Soldado crearSoldado(String tipo, int id, Random random) {
        String nombre = tipo + " " + nombreReino + " #" + id;
        int fila = random.nextInt(10);
        int columna = random.nextInt(10);

        return switch (tipo) {
            case "Espadachin" -> new Espadachin(nombre, random.nextInt(3) + 8, 10, 8, fila, columna, random.nextDouble() * 1.5 + 0.5);
            case "Arquero" -> new Arquero(nombre, random.nextInt(3) + 3, 7, 3, fila, columna, random.nextInt(10) + 5);
            case "Caballero" -> new Caballero(nombre, random.nextInt(3) + 10, 13, 7, fila, columna, random.nextBoolean());
            default -> new Lancero(nombre, random.nextInt(3) + 5, 5, 10, fila, columna, random.nextDouble() * 2 + 1.0);
        };
    }

    // Obtener todos los soldados
    public List<Soldado> getSoldados() {
        return soldados;
    }

    // Mostrar detalles del ejército
    public void mostrarEjercito() {
        System.out.println("Reino: " + nombreReino);
        for (Soldado soldado : soldados) {
            System.out.println(soldado);
        }
    }
}
