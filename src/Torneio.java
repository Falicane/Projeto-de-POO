package src;

import java.util.ArrayList;

/**
 * Gerencia o torneio, agora usando composição com RegrasTorneio.
 */

public class Torneio {
    private ArrayList<Competidor> competidores;
    private RegrasTorneio regras;

    public Torneio() {
        competidores = new ArrayList<>();
        regras = new RegrasTorneio();
    }

    public void adicionarCompetidor(Competidor c) {
        competidores.add(c);
    }

    public void iniciarTorneio() {
        System.out.println("Iniciando torneio!");
        while (competidores.size() > 1) {
            Competidor vencedor = realizarLuta(competidores.get(0), competidores.get(1));
            competidores.remove(vencedor == competidores.get(0) ? 1 : 0);
        }
        System.out.println("Campeão: " + competidores.get(0).getNome());
    }

    protected Competidor realizarLuta(Competidor c1, Competidor c2) {
        System.out.println(c1.getDescricao() + " VS " + c2.getDescricao());
        return regras.determinarVencedor(c1, c2);
    }
}