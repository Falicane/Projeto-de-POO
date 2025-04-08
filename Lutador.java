
class Lutador {

    private String nome;
    private String estiloluta;
    private int habilidade;

    public Lutador(String nome, String estiloluta, int habilidade) {
        this.nome = nome;
        this.estiloluta = estiloluta;
        this.habilidade = habilidade;
    }

    public String getNome() {
        return nome;
    }

    public int getHabilidade() {
        return habilidade;
    }

    @Override
    public String toString() {
        return nome + " - Estilo: " + estiloluta + " - Habilidade: " + habilidade;
    }

}
