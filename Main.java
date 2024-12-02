public class Main {
    public static void main(String[] args) {
        // Crear dos ejércitos
        Ejercito ejercito1 = new Ejercito("Inglaterra", false); // Usar arreglo estándar
        Ejercito ejercito2 = new Ejercito("Francia", true);    // Usar ArrayList

        // Generar soldados
        ejercito1.generarSoldados(10);
        ejercito2.generarSoldados(10);

        // Crear el mapa
        Mapa mapa = new Mapa("Bosque");

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
