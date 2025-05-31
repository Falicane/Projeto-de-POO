package torneio;

/**
 * Representa um lutador de MMA, com nome, estilo de luta, habilidade e pontos.
 * Herda de CompetidorBase e implementa getDescricao.
 */
public class Lutador extends CompetidorBase {
    private EstiloLuta estiloLuta;
    private int pontos;

    /**
     * Construtor completo para criar um lutador.
     * @param nome Nome do lutador.
     * @param estiloLuta Estilo de luta do lutador.
     * @param habilidade Habilidade do lutador (0-100).
     * @throws IllegalArgumentException se o nome for inválido ou estilo for nulo.
     * @throws HabilidadeInvalidaException se a habilidade for inválida.
     */
    public Lutador(String nome, EstiloLuta estiloLuta, int habilidade) {
        super(nome, habilidade);
        if (estiloLuta == null) {
            throw new IllegalArgumentException("Estilo de luta não pode ser nulo");
        }
        this.estiloLuta = estiloLuta;
        this.pontos = 0;
    }

    /**
     * Construtor alternativo com estilo padrão MMA.
     * @param nome Nome do lutador.
     * @param habilidade Habilidade do lutador (0-100).
     * @throws IllegalArgumentException se o nome for inválido.
     * @throws HabilidadeInvalidaException se a habilidade for inválida.
     */
    public Lutador(String nome, int habilidade) {
        this(nome, EstiloLuta.MMA, habilidade);
    }

    /**
     * Obtém o estilo de luta do lutador.
     * @return Estilo de luta.
     */
    public EstiloLuta getEstiloLuta() {
        return estiloLuta;
    }

    /**
     * Define o estilo de luta do lutador.
     * @param estiloLuta Novo estilo de luta.
     * @throws IllegalArgumentException se o estilo for nulo.
     */
    public void setEstiloLuta(EstiloLuta estiloLuta) {
        if (estiloLuta == null) {
            throw new IllegalArgumentException("Estilo de luta não pode ser nulo");
        }
        this.estiloLuta = estiloLuta;
    }

    /**
     * Obtém os pontos acumulados pelo lutador.
     * @return Pontos do lutador.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Incrementa os pontos do lutador após uma vitória.
     */
    public void adicionarPonto() {
        this.pontos++;
    }

    /**
     * Obtém a descrição completa do lutador.
     * @return String com nome, estilo, habilidade e pontos.
     */
    @Override
    public String getDescricao() {
        return getNome() + " - Estilo: " + estiloLuta.getNome() + 
               " - Habilidade: " + getHabilidade() + 
               " - Pontos: " + pontos;
    }
}