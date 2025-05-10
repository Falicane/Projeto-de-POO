package src;

import javax.swing.JTextArea;

/**
 * Subclasse de Torneio que registra os resultados em um JTextArea (GUI).
 * Herda de Torneio e sobrescreve métodos para adicionar logs.
 */

public class TorneioLogger extends Torneio {
    private JTextArea logArea;

    public TorneioLogger(JTextArea logArea) {
        super();
        this.logArea = logArea;
    }

    @Override
    public void adicionarCompetidor(Competidor c) {
        super.adicionarCompetidor(c);
        logArea.append("Competidor adicionado: " + c.getNome() + "\n");
    }

    @Override
    public void iniciarTorneio() {
        logArea.append("--- INÍCIO DO TORNEIO ---\n");
        super.iniciarTorneio();
    }

    @Override
    protected Competidor realizarLuta(Competidor c1, Competidor c2) {
        logArea.append("\nLuta: " + c1.getNome() + " vs " + c2.getNome() + "\n");
        Competidor vencedor = super.realizarLuta(c1, c2);
        logArea.append("Vencedor: " + vencedor.getNome() + "\n");
        return vencedor;
    }
}