public class Main {
    public static void main(String[] args) {
        Ejercito ejercito1 = new Ejercito("Inglaterra", false);
        Ejercito ejercito2 = new Ejercito("Francia", true);

        ejercito1.generarSoldados(10);
        ejercito2.generarSoldados(10);

        Mapa mapa = new Mapa("Bosque");

        mapa.aplicarBonus(ejercito1);
        mapa.aplicarBonus(ejercito2);

        System.out.println("\nEstadisticas del Ejercito 1:");
        System.out.println("Promedio de nivel de vida: " + ejercito1.promedioNivelVida());
        System.out.println("Soldado con mayor nivel de vida: " + ejercito1.soldadoMayorVida());

        System.out.println("\nEstadisticas del Ejercito 2:");
        System.out.println("Promedio de nivel de vida: " + ejercito2.promedioNivelVida());
        System.out.println("Soldado con mayor nivel de vida: " + ejercito2.soldadoMayorVida());

        System.out.println("\nRanking de poder del Ejercito 1:");
        ejercito1.rankingDePoder();

        System.out.println("\nRanking de poder del Ejercito 2:");
        ejercito2.rankingDePoder();

        for (Soldado soldado : ejercito1.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }
        for (Soldado soldado : ejercito2.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }

        System.out.println("Mapa de batalla:");
        mapa.mostrarTablero(ejercito1, ejercito2);
        System.out.println("\nEjercito 1:");
        ejercito1.mostrarEjercito();
        System.out.println("\nEjercito 2:");
        ejercito2.mostrarEjercito();

        System.out.println("\nResultado del combate:");
        Batalla.mostrarResultado(ejercito1, ejercito2);
    }
}