package src;

import javax.swing.JTextArea;

/**
 * Subclasse de Torneio que registra eventos do torneio em um JTextArea.
 * Sobrescreve métodos para adicionar logs visuais na interface gráfica.
 */
public class TorneioLogger extends Torneio {
    private JTextArea logArea;

    /**
     * Construtor que inicializa o logger com um JTextArea.
     * @param logArea Área de texto para exibir os logs.
     * @throws IllegalArgumentException se logArea for nulo.
     */
    public TorneioLogger(JTextArea logArea) {
        super();
        if (logArea == null) {
            throw new IllegalArgumentException("Área de log não pode ser nula");
        }
        this.logArea = logArea;
    }

    /**
     * Adiciona um competidor e registra o evento no log.
     * @param c O competidor a ser adicionado.
     */
    @Override
    public void adicionarCompetidor(Competidor c) {
        super.adicionarCompetidor(c);
        logArea.append("Competidor adicionado: " + c.getDescricao() + "\n");
    }

    /**
     * Inicia o torneio e registra o início no log.
     */
    @Override
    public void iniciarTorneio() {
        logArea.append("--- INÍCIO DO TORNEIO ---\n");
        super.iniciarTorneio();
        // Registra o campeão no log
        if (getNumeroCompetidores() == 1) {
            logArea.append("Campeão: " + getCompetidores().get(0).getDescricao() + "\n");
        }
    }

    /**
     * Realiza uma luta, registra a luta e o vencedor no log.
     * @param c1 Primeiro competidor.
     * @param c2 Segundo competidor.
     * @return O competidor vencedor.
     */
    @Override
    protected Competidor realizarLuta(Competidor c1, Competidor c2) {
        logArea.append("\nLuta: " + c1.getDescricao() + " vs " + c2.getDescricao() + "\n");
        Competidor vencedor = super.realizarLuta(c1, c2);
        logArea.append("Vencedor: " + vencedor.getDescricao() + "\n");
        return vencedor;
    }
}