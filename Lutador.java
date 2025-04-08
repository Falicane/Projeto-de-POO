/**
 * Representa um Lutador que participa num torneio de MMA.
 * Cada lutador tem um nome, um estilo de luta e uma habilidade que influencia o combate.
 */
public class Lutador implements Competidor {

    // Atributos principais do lutador
    private String nome;
    private String estiloluta;
    private int habilidade;

    /**
     * Construtor principal do Lutador.
     *
     * @param nome Nome do lutador
     * @param estiloluta Estilo de luta (ex: Boxe, Muay Thai)
     * @param habilidade Valor da habilidade (0 a 100)
     */
    public Lutador(String nome, String estiloluta, int habilidade) {
        this.nome = nome;
        this.estiloluta = estiloluta;
        this.habilidade = habilidade;
    }

    /**
     * Obtém o nome do lutador.
     *
     * @return Nome do lutador
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o nível de habilidade do lutador.
     *
     * @return Valor da habilidade
     */
    @Override
    public int getHabilidade() {
        return habilidade;
    }

    /**
     * Fornece uma descrição do lutador com nome, estilo e habilidade.
     *
     * @return Texto descritivo
     */
    @Override
    public String getDescricao() {
        return nome + " - Estilo: " + estiloluta + " - Habilidade: " + habilidade;
    }

    /**
     * Representação textual do objeto (usado ao imprimir).
     *
     * @return Texto descritivo igual ao de getDescricao()
     */
    @Override
    public String toString() {
        return getDescricao();
    }
}