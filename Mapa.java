import java.util.*;
public class Mapa {
    private String tipoTerritorio;
    private Soldado[][] tablero;
    private Random random;

    public Mapa(String tipoTerritorio) {
        this.tipoTerritorio = tipoTerritorio;
        this.tablero = new Soldado[10][10]; 
        this.random = new Random();
    }

    public boolean colocarSoldado(Soldado soldado) {
        int fila, columna;
        do {
            fila = random.nextInt(10);
            columna = random.nextInt(10);
        } while (tablero[fila][columna] != null); 

        tablero[fila][columna] = soldado;
        soldado.mover(fila, columna);
        return true;
    }

    public void aplicarBonus(Ejercito ejercito) {
        System.out.println("Aplicando bonus para el territorio: " + tipoTerritorio);
        for (Soldado soldado : ejercito.getSoldados()) {
            if (seBeneficiaDelTerritorio(ejercito.getNombreReino())) {
                System.out.println(soldado.getNombre() + " recibe +1 de nivel de vida por el territorio.");
                soldado.nivelVida += 1; 
            }
        }
    }

    private boolean seBeneficiaDelTerritorio(String reino) {
        return switch (reino) {
            case "Inglaterra", "Sacro Imperio Romano-Germánico" -> tipoTerritorio.equals("Bosque");
            case "Francia" -> tipoTerritorio.equals("Campo Abierto");
            case "Castilla-Aragón" -> tipoTerritorio.equals("Montaña");
            case "Moros" -> tipoTerritorio.equals("Desierto");
            default -> false;
        };
    }

    public void mostrarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[   ] ");
                } else {
                    System.out.print("[ " + tablero[i][j].getNombre().charAt(0) + " ] ");
                }
            }
            System.out.println();
        }
    }

    public String getTipoTerritorio() {
        return tipoTerritorio;
    }
}
