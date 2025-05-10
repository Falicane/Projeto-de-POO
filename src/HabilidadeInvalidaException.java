package src;

/**
 * Exceção lançada quando a habilidade é inválida (<0 ou >100).
 */
public class HabilidadeInvalidaException extends RuntimeException {
    public HabilidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
