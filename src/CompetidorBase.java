package src;

/**
 * Classe abstrata que implementa atributos/métodos comuns a todos os competidores.
 */
public abstract class CompetidorBase implements Competidor {
    private String nome;
    private int habilidade;

    public CompetidorBase(String nome, int habilidade) {
        if (habilidade < 0 || habilidade > 100) {
            throw new HabilidadeInvalidaException("Habilidade deve estar entre 0 e 100");
        }
        this.nome = nome;
        this.habilidade = habilidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getHabilidade() {
        return habilidade;
    }
}
