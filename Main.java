public class Main {
    public static void main(String[] args) {
        // Crear dos ejércitos
        Ejercito ejercito1 = new Ejercito("Inglaterra", false);
        Ejercito ejercito2 = new Ejercito("Francia", true);

        // Generar soldados
        ejercito1.generarSoldados(10);
        ejercito2.generarSoldados(10);

        // Crear el mapa
        Mapa mapa = new Mapa("Bosque");

        // Aplicar bonus a los soldados según el territorio
        mapa.aplicarBonus(ejercito1);
        mapa.aplicarBonus(ejercito2);

        // Colocar soldados en el mapa
        for (Soldado soldado : ejercito1.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }
        for (Soldado soldado : ejercito2.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }

        // Mostrar el tablero y los ejércitos
        System.out.println("Mapa de batalla:");
        mapa.mostrarTablero();
        System.out.println("\nEjército 1:");
        ejercito1.mostrarEjercito();
        System.out.println("\nEjército 2:");
        ejercito2.mostrarEjercito();
    }
}
