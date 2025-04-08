// Classe principal para iniciar o torneio de MMA
public class TorneioMMA {
    public static void main(String[] args) {

        // Criação de lutadores
        Lutador lutador1 = new Lutador("Anderson Silva", "Muay Thai", 85);
        Lutador lutador2 = new Lutador("Jon Jones", "Kickboxing", 90);
        Lutador lutador3 = new Lutador("Khabib Nurmagomedov", "Jiu-Jitsu", 88);
        Lutador lutador4 = new Lutador("Conor McGregor", "Boxe", 80);

        // Criação do torneio
        Torneio torneio = new Torneio();
        torneio.adicionarLutador(lutador1);
        torneio.adicionarLutador(lutador2);
        torneio.adicionarLutador(lutador3);
        torneio.adicionarLutador(lutador4);

        // Executando o torneio
        torneio.iniciarTorneio();

    }

}