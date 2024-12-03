import java.util.*;
public class ComparadorPorVida implements Comparator<Soldado>{

    @Override
    public int compare(Soldado s1, Soldado s2) {
        return Integer.compare(s2.getNivelVida(), s1.getNivelVida());
    }  
}