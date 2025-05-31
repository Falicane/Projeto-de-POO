
/**
 * Classe de testes unitários para as entidades do sistema de torneios de luta.
 * Utiliza JUnit 5 para verificar o comportamento esperado das classes:
 * - Lutador: entidade que representa um participante.
 * - Torneio: classe que gere os combates e o campeonato.
 * - TorneioLogger: componente de logging de eventos.
 *
 * Os testes validam a criação correta de lutadores, o lançamento de exceções,
 * o fluxo de torneio e a integração entre os componentes.
 */

package torneio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;

public class TorneioTest {

    private Torneio t; // Objeto principal de gestão do torneio
    private JTextArea log; // Área de texto usada pelo logger para registar eventos

    /**
     * Configuração comum a todos os testes.
     * Cria uma nova instância de torneio e associa o JTextArea ao logger.
     */
    @BeforeEach
    public void setup() {
        log = new JTextArea();
        TorneioLogger.setLogTextArea(log);
        t = new Torneio();
    }

    /**
     * Testa a criação de um lutador válido e valida os seus atributos principais.
     */
    @Test
    @DisplayName("Criar lutador válido")
    public void criarLutadorValido() {
        Lutador lutador = new Lutador("Lutador1", EstiloLuta.JIU_JITSU, 50);

        // assertAll permite agrupar várias verificações numa única execução
        assertAll("Atributos do lutador",
                () -> assertEquals("Lutador1", lutador.getNome()),
                () -> assertEquals(EstiloLuta.JIU_JITSU, lutador.getEstiloLuta()),
                () -> assertEquals(50, lutador.getHabilidade()),
                () -> assertEquals(0, lutador.getPontos()),
                () -> assertEquals("Valido - Estilo: Jiu-Jitsu - Habilidade: 50 - Pontos: 0", lutador.getDescricao()));
    }

    /**
     * Testa a criação de lutadores com habilidades inválidas.
     * Deve lançar uma exceção HabilidadeInvalidaException.
     */
    @Test
    @DisplayName("Criar lutador com habilidade inválida")
    public void criarLutadorHabilidadeInvalida() {
        assertThrows(HabilidadeInvalidaException.class, () -> {
            new Lutador("Lutador2", EstiloLuta.MMA, -10);
        });
        assertThrows(HabilidadeInvalidaException.class, () -> {
            new Lutador("Lutador3", EstiloLuta.BOXE, 120);
        });
    }

    /**
     * Testa a adição de um competidor ao torneio.
     * Verifica se o logger contém a mensagem de confirmação.
     */
    @Test
    @DisplayName("Adicionar competidor ao torneio")
    public void adicionarCompetidor() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.MUAY_THAI, 70);
        t.adicionarCompetidor(l1);

        String logText = log.getText();
        assertTrue(logText.contains("Competidor adicionado: Lutador1"));
    }

    /**
     * Testa o comportamento do torneio quando tem menos de dois lutadores.
     * Espera-se que lance uma exceção ao tentar iniciar.
     */
    @Test
    @DisplayName("Iniciar torneio com menos de dois competidores")
    public void iniciarTorneioComPoucosCompetidores() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.BOXE, 60);
        t.adicionarCompetidor(l1);

        assertThrows(IllegalStateException.class, () -> {
            t.comecarTorneio();
        });
    }

    /**
     * Testa um fluxo completo de torneio com dois competidores.
     * Após o torneio, verifica-se se o campeão é um dos lutadores adicionados.
     */
    @Test
    @DisplayName("Fluxo completo do torneio")
    public void fluxoCompletoDoTorneio() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.WRESTLING, 80);
        Lutador l2 = new Lutador("Lutador2", EstiloLuta.MMA, 75);

        t.adicionarCompetidor(l1);
        t.adicionarCompetidor(l2);
        t.comecarTorneio();

        Lutador campeao = t.getCampeao();

        // Valida que o campeão é um dos dois lutadores
        assertTrue(campeao.equals(l1) || campeao.equals(l2));
    }

    /**
     * Testa o comportamento quando se tenta adicionar um lutador nulo.
     * Espera-se uma exceção IllegalArgumentException.
     */
    @Test
    @DisplayName("Adicionar lutador nulo")
    public void adicionarLutadorNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            t.adicionarCompetidor(null);
        });
    }
}
