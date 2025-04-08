import java.util.ArrayList;
import java.util.Random;

class Torneio {

    private ArrayList<Lutador> lutadores;

    public Torneio() {
        lutadores = new ArrayList<>();
    }

    public void adicionarLutador(Lutador lutador) {
        lutadores.add(lutador);
    }

    public void iniciarTorneio() {
        System.out.println("Iniciando o torneio de MMA!");

        while (lutadores.size() > 1) {
            Lutador vencedor = realiazarLuta(lutadores.get(0), lutadores.get(1));
            System.out.println("Vencedor: " + vencedor.getNome());
            lutadores.remove(vencedor == lutadores.get(0) ? 1 : 0);

        }

        System.out.println("Campeão do torneio: " + lutadores.get(0).getNome());

    }

    private Lutador realiazarLuta(Lutador l1, Lutador l2) {
        System.out.println("Luta entre: " + l1 + " VS " + l2);

        Random random = new Random();
        int resultado = random.nextInt(l1.getHabilidade() + l2.getHabilidade());

        return resultado < l1.getHabilidade() ? l1 : l2;

    }

}
