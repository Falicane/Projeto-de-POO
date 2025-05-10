package src;

/**
 * Representa um lutador de MMA, agora herdando de CompetidorBase.
 */
public class Lutador extends CompetidorBase {
    private String estiloLuta;

    public Lutador(String nome, String estiloLuta, int habilidade) {
        super(nome, habilidade);
        this.estiloLuta = estiloLuta;
    }

    // Construtor alternativo (sobrecarga)
    public Lutador(String nome, int habilidade) {
        this(nome, "MMA", habilidade);
    }

    @Override
    public String getDescricao() {
        return getNome() + " - Estilo: " + estiloLuta + " - Habilidade: " + getHabilidade();
    }
}