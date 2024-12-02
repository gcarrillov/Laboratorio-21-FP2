import java.util.Random;

public class Batalla {
    public static void calcularResultado(Ejercito ejercito1, Ejercito ejercito2) {
        int vidaTotal1 = ejercito1.nivelVidaTotal();
        int vidaTotal2 = ejercito2.nivelVidaTotal();

        double probabilidad1 = (double) vidaTotal1 / (vidaTotal1 + vidaTotal2) * 100;
        double probabilidad2 = 100 - probabilidad1;

        System.out.println("Probabilidad de victoria:");
        System.out.printf("%s: %.2f%%\n", ejercito1.getNombreReino(), probabilidad1);
        System.out.printf("%s: %.2f%%\n", ejercito2.getNombreReino(), probabilidad2);

        Random random = new Random();
        double resultado = random.nextDouble() * 100;

        String ganador = (resultado <= probabilidad1) ? ejercito1.getNombreReino() : ejercito2.getNombreReino();
        System.out.printf("El ganador es: %s\n", ganador);
    }
}
