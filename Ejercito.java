import java.util.*;
public class Ejercito {
    private String nombreReino;
    private List<Soldado> soldados;

    public Ejercito(String nombreReino, boolean usarArrayList) {
        this.nombreReino = nombreReino;
        if (usarArrayList) {
            soldados = new ArrayList<>();
        } else {
            soldados = new ArrayList<>(10); 
        }
    }

    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

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

    private Soldado crearSoldado(String tipo, int id, Random random) {
        String nombre = tipo + " " + nombreReino + " #" + id;
        int fila = random.nextInt(10);      
        int columna = random.nextInt(10);
    
        return switch (tipo) {
            case "Espadachin" -> new Espadachin(
                nombre,
                random.nextInt(3) + 8,    
                10,                        
                8,                        
                fila,
                columna,
                random.nextDouble() * 1.5 + 0.5 
            );
            case "Arquero" -> new Arquero(
                nombre,
                random.nextInt(3) + 3,     
                7,                          
                3,                         
                fila,
                columna,
                random.nextInt(10) + 5     
            );
            case "Caballero" -> new Caballero(
                nombre,
                random.nextInt(3) + 10,     
                13,                        
                7,                          
                fila,
                columna,
                random.nextBoolean()        
            );
            case "Lancero" -> new Lancero(
                nombre,
                random.nextInt(3) + 5,      
                5,                         
                10,                         
                fila,
                columna,
                random.nextDouble() * 2 + 1.0 
            );
            default -> throw new IllegalArgumentException("Tipo de soldado desconocido: " + tipo);
        };
    }
    

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void mostrarEjercito() {
        System.out.println("Reino: " + nombreReino);
        for (Soldado soldado : soldados) {
            System.out.println(soldado);
        }
    }

    public String getNombreReino() {
        return nombreReino;
    }

    public double promedioNivelVida() {
        return soldados.stream()
                .mapToInt(Soldado::getNivelVida)
                .average()
                .orElse(0.0);
    }

    public Soldado soldadoMayorVida() {
        return soldados.stream()
                .max(Comparator.comparingInt(Soldado::getNivelVida))
                .orElse(null);
    }

    public List<Soldado> rankingDePoder() {
        return soldados.stream()
                .sorted(Comparator.comparingInt(Soldado::getNivelVida).reversed())
                .toList();
    }

    public int nivelVidaTotal() {
        return soldados.stream()
                .mapToInt(Soldado::getNivelVida)
                .sum();
    }
    
    public static String crearReino(){
        Random r = new Random();
        switch (r.nextInt(5)+1){
            case 1:
                return "Inglaterra";
            case 2:
                return "Francia";
            case 3:
                return "Castilla-Aragon";
            case 4:
                return "Moros";
            case 5:
                return "Sacro Imperio Romano-Germanico";
            default:
                break;
        }
        return "";
    }
}
