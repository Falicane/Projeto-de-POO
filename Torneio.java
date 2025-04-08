import java.util.ArrayList;
import java.util.Random;

/**
 * Representa um Torneio onde vários competidores se enfrentam até haver um campeão.
 */
public class Torneio {

    // Lista de participantes no torneio
    private ArrayList<Competidor> competidores;

    /**
     * Construtor padrão. Inicializa a lista de competidores.
     */
    public Torneio() {
        competidores = new ArrayList<>();
    }

    /**
     * Adiciona um novo competidor ao torneio.
     *
     * @param c Instância de Competidor (ex: Lutador)
     */
    public void adicionarCompetidor(Competidor c) {
        competidores.add(c);
    }

    /**
     * Executa o torneio até restar apenas um vencedor.
     * Realiza sucessivos combates entre os primeiros dois competidores da lista.
     */
    public void iniciarTorneio() {
        System.out.println("Iniciando o torneio de MMA!");

        try {
            while (competidores.size() > 1) {
                Competidor vencedor = realizarLuta(competidores.get(0), competidores.get(1));
                System.out.println("Vencedor: " + vencedor.getNome());
                // Elimina o perdedor
                competidores.remove(vencedor == competidores.get(0) ? 1 : 0);
            }

            if (competidores.isEmpty()) {
                System.out.println("Erro: nenhum competidor disponível.");
            } else {
                System.out.println("Campeão do torneio: " + competidores.get(0).getNome());
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao tentar aceder a competidores: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    /**
     * Simula uma luta entre dois competidores.
     * O vencedor é escolhido com base numa probabilidade proporcional à sua habilidade.
     *
     * @param c1 Primeiro competidor
     * @param c2 Segundo competidor
     * @return Vencedor da luta
     */
    private Competidor realizarLuta(Competidor c1, Competidor c2) {
        System.out.println("Luta entre: " + c1.getDescricao() + " VS " + c2.getDescricao());

        Random random = new Random();
        int resultado = random.nextInt(c1.getHabilidade() + c2.getHabilidade());

        return resultado < c1.getHabilidade() ? c1 : c2;
    }
}