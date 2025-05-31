package torneio;

/**
 * Interface que define o contrato para um competidor no torneio de MMA.
 * Qualquer classe que represente um competidor deve implementar esta interface.
 */
public interface Competidor {
    /**
     * Obtém o nome do competidor.
     * @return Nome do competidor.
     */
    String getNome();

    /**
     * Obtém a habilidade do competidor (valor entre 0 e 100).
     * @return Habilidade do competidor.
     */
    int getHabilidade();

    /**
     * Obtém uma descrição detalhada do competidor.
     * @return Descrição do competidor, incluindo nome, estilo e habilidade.
     */
    String getDescricao();
}