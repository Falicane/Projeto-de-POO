package src;

/**
 * Enumeração que define os estilos de luta disponíveis para lutadores no torneio.
 */
public enum EstiloLuta {
    JIU_JITSU("Jiu-Jitsu"),
    BOXE("Boxe"),
    MUAY_THAI("Muay Thai"),
    WRESTLING("Wrestling"),
    MMA("MMA");

    private final String nome;

    /**
     * Construtor do estilo de luta.
     * @param nome Nome do estilo.
     */
    EstiloLuta(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome do estilo de luta.
     * @return Nome do estilo.
     */
    public String getNome() {
        return nome;
    }
}