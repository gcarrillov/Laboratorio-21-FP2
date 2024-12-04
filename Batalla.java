import java.util.Random;

public class Batalla {
    
    public static void mostrarResultado(Ejercito ejercito1, Ejercito ejercito2) {
        // Mostrar encabezado de la probabilidad de victoria
        mostrarEncabezadoResultados();

        // Mostrar la probabilidad de victoria de ambos ejércitos
        double probabilidadEjercito1 = calcularProb(ejercito1, ejercito2);
        double probabilidadEjercito2 = calcularProb(ejercito2, ejercito1);

        System.out.println("| " + ejercito1.getNombreReino() + " | VS | " + ejercito2.getNombreReino() + " |");
        System.out.println("---------------------------------");
        System.out.printf("|    %.2f%%     |     %.2f%%    |\n", probabilidadEjercito1, probabilidadEjercito2);
        System.out.println("---------------------------------");

        // Determinar el ganador basado en las probabilidades
        String ganador = determinarGanador(probabilidadEjercito1, probabilidadEjercito2);
        System.out.printf("El ganador es: %s\n", ganador);
    }

    // Método para mostrar un encabezado más claro y limpio
    private static void mostrarEncabezadoResultados() {
        System.out.println("---------------------------------");
        System.out.println("|   Probabilidad de victoria    |");
        System.out.println("---------------------------------");
    }

    // Método que calcula la probabilidad de victoria de un ejército
    public static double calcularProb(Ejercito calcularProb, Ejercito ejercitoRival) {
        int vidaTotal1 = calcularProb.nivelVidaTotal();
        int vidaTotal2 = ejercitoRival.nivelVidaTotal();

        // Optimización: Eliminamos el redondeo innecesario
        return (double) vidaTotal1 / (vidaTotal1 + vidaTotal2) * 100;
    }

    // Método que determina al ganador en función de la probabilidad
    private static String determinarGanador(double probabilidadEjercito1, double probabilidadEjercito2) {
        Random random = new Random();
        double resultado = random.nextDouble() * 100;

        // El ganador es el ejército cuya probabilidad de victoria es mayor
        return (resultado <= probabilidadEjercito1) ? "Ejército 1" : "Ejército 2";
    }
}
