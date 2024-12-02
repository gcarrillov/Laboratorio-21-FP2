public class Main {
    public static void main(String[] args) {
        Ejercito ejercito1 = new Ejercito("Inglaterra", false);
        Ejercito ejercito2 = new Ejercito("Francia", true);

        ejercito1.generarSoldados(10);
        ejercito2.generarSoldados(10);

        Mapa mapa = new Mapa("Bosque");

        mapa.aplicarBonus(ejercito1);
        mapa.aplicarBonus(ejercito2);

        for (Soldado soldado : ejercito1.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }
        for (Soldado soldado : ejercito2.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }

        System.out.println("Mapa de batalla:");
        mapa.mostrarTablero();
        System.out.println("\nEjército 1:");
        ejercito1.mostrarEjercito();
        System.out.println("\nEjército 2:");
        ejercito2.mostrarEjercito();
    }
}
