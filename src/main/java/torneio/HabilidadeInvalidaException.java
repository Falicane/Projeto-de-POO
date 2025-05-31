package torneio;

/**
 * Exceção lançada quando a habilidade de um competidor é inválida (fora do intervalo 0-100).
 */
public class HabilidadeInvalidaException extends RuntimeException {
    /**
     * Construtor que define a mensagem de erro.
     * @param mensagem Mensagem descrevendo o erro.
     */
    public HabilidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}