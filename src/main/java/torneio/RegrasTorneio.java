package torneio;

import java.util.Random;

/**
 * Encapsula as regras para determinar o vencedor de uma luta no torneio.
 * Usa um algoritmo baseado em habilidade e aleatoriedade.
 */
public class RegrasTorneio {
    /**
     * Determina o vencedor entre dois competidores com base em suas habilidades.
     * @param c1 Primeiro competidor.
     * @param c2 Segundo competidor.
     * @return O competidor vencedor.
     */
    public Competidor determinarVencedor(Competidor c1, Competidor c2) {
        Random random = new Random();
        // Soma das habilidades define o intervalo para o sorteio
        int somaHabilidades = c1.getHabilidade() + c2.getHabilidade();
        // Se ambos têm habilidade 0, retorna aleatoriamente um dos dois
        if (somaHabilidades == 0) {
            return random.nextBoolean() ? c1 : c2;
        }
        int resultado = random.nextInt(somaHabilidades);
        // O competidor com maior habilidade tem maior chance de vencer
        return resultado < c1.getHabilidade() ? c1 : c2;
    }
}
