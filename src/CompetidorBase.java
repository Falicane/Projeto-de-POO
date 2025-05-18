package src;

/**
 * Classe abstrata que fornece atributos e métodos comuns para todos os competidores.
 * Implementa a interface Competidor e valida atributos no construtor.
 */
public abstract class CompetidorBase implements Competidor {
    private String nome;
    private int habilidade;

    /**
     * Construtor que inicializa nome e habilidade, com validações.
     * @param nome Nome do competidor.
     * @param habilidade Habilidade do competidor (0-100).
     * @throws IllegalArgumentException se o nome for nulo ou vazio.
     * @throws HabilidadeInvalidaException se a habilidade for inválida.
     */
    public CompetidorBase(String nome, int habilidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (habilidade < 0 || habilidade > 100) {
            throw new HabilidadeInvalidaException("Habilidade deve estar entre 0 e 100");
        }
        this.nome = nome;
        this.habilidade = habilidade;
    }

    /**
     * Obtém o nome do competidor.
     * @return Nome do competidor.
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a habilidade do competidor.
     * @return Habilidade do competidor.
     */
    @Override
    public int getHabilidade() {
        return habilidade;
    }
}