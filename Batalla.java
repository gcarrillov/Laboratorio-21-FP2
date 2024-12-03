import java.util.Random;

public class Batalla {
    public static void mostrarResultado(Ejercito ejercito1, Ejercito ejercito2) {
        System.out.println("--------------------------");
        System.out.println("|Probabilidad de victoria|");
        System.out.println("--------------------------");
        System.out.println("|" + ejercito1.getNombreReino() + "| VS |" + ejercito2.getNombreReino() + "|");
        System.out.println("--------------------------");
        System.out.println("|   " + calcularProb(ejercito1,ejercito2)+ "%  |   " + calcularProb(ejercito2,ejercito1) + "%    |");
        System.out.println("--------------------------");

        Random random = new Random();
        double resultado = random.nextDouble() * 100;

        String ganador = (resultado <= calcularProb(ejercito1,ejercito2)) ? ejercito1.getNombreReino() : ejercito2.getNombreReino();
        System.out.printf("El ganador es: %s\n", ganador);
    }
    public static double calcularProb(Ejercito calcularProb,Ejercito ejercitoRival){
        int vidaTotal1 = calcularProb.nivelVidaTotal();
        int vidaTotal2 = ejercitoRival.nivelVidaTotal();
        
        double resultado= (double) vidaTotal1 / (vidaTotal1 + vidaTotal2) * 100;
        resultado=100*resultado;
        resultado=(double) Math.round(resultado);
        resultado= resultado/100;
        return resultado;
    }
}
