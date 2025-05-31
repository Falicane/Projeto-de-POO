package torneio;

import java.util.ArrayList;

/**
 * Gerencia o torneio de MMA, organizando lutas, determinando o campeão e
 * gerenciando pontos.
 * Usa composição com RegrasTorneio para determinar vencedores.
 */
public class Torneio {
    private ArrayList<Competidor> competidores;
    private RegrasTorneio regras;

    /**
     * Construtor que inicializa a lista de competidores e as regras.
     */
    public Torneio() {
        competidores = new ArrayList<>();
        regras = new RegrasTorneio();
    }

    /**
     * Adiciona um competidor ao torneio.
     * 
     * @param c O competidor a ser adicionado.
     * @throws IllegalArgumentException se o competidor for nulo.
     */
    public void adicionarCompetidor(Competidor c) {
        if (c == null) {
            throw new IllegalArgumentException("Competidor não pode ser nulo");
        }
        competidores.add(c);
    }

    /**
     * Inicia o torneio, realizando lutas até restar um campeão.
     * 
     * @throws IllegalStateException se houver menos de dois competidores.
     */
    public void iniciarTorneio() {
        if (competidores.size() < 2) {
            throw new IllegalStateException("O torneio requer pelo menos dois competidores");
        }
        System.out.println("Iniciando torneio!");
        // Usa iteração for-each para demonstrar uso de coleções
        while (competidores.size() > 1) {
            Competidor c1 = competidores.get(0);
            Competidor c2 = competidores.get(1);
            Competidor vencedor = realizarLuta(c1, c2);
            // Incrementa pontos do vencedor, se for um Lutador
            if (vencedor instanceof Lutador) {
                ((Lutador) vencedor).adicionarPonto();
            }
            // Remove o perdedor
            competidores.remove(vencedor == c1 ? c2 : c1);
        }
        System.out.println("Campeão: " + competidores.get(0).getDescricao());
    }

    /**
     * Realiza uma luta entre dois competidores e retorna o vencedor.
     * 
     * @param c1 Primeiro competidor.
     * @param c2 Segundo competidor.
     * @return O competidor vencedor.
     */
    protected Competidor realizarLuta(Competidor c1, Competidor c2) {
        System.out.println(c1.getDescricao() + " VS " + c2.getDescricao());
        return regras.determinarVencedor(c1, c2);
    }

    /**
     * Obtém o número de competidores no torneio.
     * 
     * @return Número de competidores.
     */
    public int getNumeroCompetidores() {
        return competidores.size();
    }

    /**
     * Obtém a lista de competidores.
     * 
     * @return Lista de competidores.
     */
    public ArrayList<Competidor> getCompetidores() {
        return new ArrayList<>(competidores); // Retorna uma cópia para proteger encapsulamento
    }

    public void comecarTorneio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comecarTorneio'");
    }

    public Lutador getCampeao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCampeao'");
    }
}