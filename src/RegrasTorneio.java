package src;

import java.util.Random;

/**
 * Encapsula as regras para determinar o vencedor de uma luta.
 */
public class RegrasTorneio {
    public Competidor determinarVencedor(Competidor c1, Competidor c2) {
        Random random = new Random();
        int resultado = random.nextInt(c1.getHabilidade() + c2.getHabilidade());
        return resultado < c1.getHabilidade() ? c1 : c2;
    }
}
