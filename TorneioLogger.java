import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;

/**
 * Variante da classe Torneio que imprime resultados para um JTextArea.
 */
public class TorneioLogger extends Torneio {

    private ArrayList<Competidor> competidores;
    private JTextArea log;

    public TorneioLogger(JTextArea log) {
        this.competidores = new ArrayList<>();
        this.log = log;
    }

    @Override
    public void adicionarCompetidor(Competidor c) {
        competidores.add(c);
    }

    @Override
    public void iniciarTorneio() {
        try {
            while (competidores.size() > 1) {
                Competidor vencedor = realizarLuta(competidores.get(0), competidores.get(1));
                log.append("Vencedor: " + vencedor.getNome() + "\n");
                competidores.remove(vencedor == competidores.get(0) ? 1 : 0);
            }

            if (!competidores.isEmpty()) {
                log.append("Campeão: " + competidores.get(0).getNome() + "\n");
            }

        } catch (Exception e) {
            log.append("Erro no torneio: " + e.getMessage() + "\n");
        }
    }

    private Competidor realizarLuta(Competidor c1, Competidor c2) {
        log.append("Luta entre: " + c1.getDescricao() + " VS " + c2.getDescricao() + "\n");

        Random random = new Random();
        int resultado = random.nextInt(c1.getHabilidade() + c2.getHabilidade());

        return resultado < c1.getHabilidade() ? c1 : c2;
    }
}