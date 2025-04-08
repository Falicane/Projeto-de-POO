/**
 * Interface que representa qualquer entidade capaz de competir num torneio.
 * Define os métodos essenciais que um competidor deve implementar.
 */
public interface Competidor {

    /**
     * Devolve o nome do competidor.
     *
     * @return Nome do competidor
     */
    String getNome();

    /**
     * Devolve a habilidade do competidor, usada para decidir lutas.
     *
     * @return Valor numérico da habilidade
     */
    int getHabilidade();

    /**
     * Fornece uma descrição detalhada do competidor.
     *
     * @return Texto descritivo (ex: nome, estilo de luta, habilidade)
     */
    String getDescricao();
}