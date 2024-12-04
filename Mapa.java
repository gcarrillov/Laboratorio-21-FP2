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

    public String aplicarBonus(Ejercito ejercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            if (seBeneficiaDelTerritorio(ejercito.getNombreReino())) {
                soldado.nivelVida += 1; 
            }
        }
        return ejercito.getNombreReino();
    }
    

    private boolean seBeneficiaDelTerritorio(String reino) {
        return switch (reino) {
            case "Inglaterra"-> tipoTerritorio.equals("Bosque");
            case "Sacro Imperio Romano-Germanico" -> tipoTerritorio.equals("Bosque") || tipoTerritorio.equals("Playa") || tipoTerritorio.equals("Campo Abierto");
            case "Francia" -> tipoTerritorio.equals("Campo Abierto");
            case "Castilla-Aragon" -> tipoTerritorio.equals("Montana");
            case "Moros" -> tipoTerritorio.equals("Desierto");
            default -> false;
        };
    }

    public void mostrarTablero(Ejercito ejercito1, Ejercito ejercito2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[   ] ");
                } else {
                    String inicial = obtenerInicialReino(tablero[i][j], ejercito1, ejercito2);
                    System.out.print("[ " + inicial + " ] ");
                }
            }
            System.out.println();
        }
    }
    
    private String obtenerInicialReino(Soldado soldado, Ejercito ejercito1, Ejercito ejercito2) {
        if (ejercito1.getSoldados().contains(soldado)) {
            return ejercito1.getNombreReino().substring(0, 1); 
        } else if (ejercito2.getSoldados().contains(soldado)) {
            return ejercito2.getNombreReino().substring(0, 1); 
        } else {
            return "?"; 
        }
    }
    
    public String getTipoTerritorio() {
        return tipoTerritorio;
    }
    
    public static String crearTerreno(){
        Random r = new Random();
        switch (r.nextInt(5)+1){
            case 1:
                return "Bosque";
            case 2:
                return "Campo Abierto";
            case 3:
                return "Montana";
            case 4:
                return "Desierto";
            case 5:
                return "Playa";
            default:
                break;
        }
        return "";
    }
}
