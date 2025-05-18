package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;

/**
 * Suite de testes para o torneio de MMA.
 * Verifica a criação de lutadores, funcionamento do torneio, pontos e logging.
 */
public class TorneioTest {
    private Torneio torneio;
    private TorneioLogger torneioLogger;
    private JTextArea logArea;

    /**
     * Configura o ambiente antes de cada teste, inicializando torneio e área de log.
     */
    @BeforeEach
    void setUp() {
        torneio = new Torneio();
        logArea = new JTextArea();
        torneioLogger = new TorneioLogger(logArea);
    }

    /**
     * Testa a criação de um lutador com habilidade e estilo válidos.
     */
    @Test
    @DisplayName("Deve criar lutador com habilidade e estilo válidos")
    void testLutadorValido() {
        Lutador lutador = new Lutador("Valido", EstiloLuta.JIU_JITSU, 50);
        assertAll("Propriedades do lutador",
            () -> assertEquals("Valido", lutador.getNome(), "Nome deve ser Valido"),
            () -> assertEquals(50, lutador.getHabilidade(), "Habilidade deve ser 50"),
            () -> assertEquals(EstiloLuta.JIU_JITSU, lutador.getEstiloLuta(), "Estilo deve ser Jiu-Jitsu"),
            () -> assertEquals(0, lutador.getPontos(), "Pontos iniciais devem ser 0"),
            () -> assertTrue(lutador.getDescricao().contains("Valido - Estilo: Jiu-Jitsu - Habilidade: 50 - Pontos: 0"),
                "Descrição deve conter todas as propriedades")
        );
    }

    /**
     * Testa se uma exceção é lançada para habilidade negativa.
     */
    @Test
    @DisplayName("Deve lançar exceção para habilidade negativa")
    void testLutadorHabilidadeNegativa() {
        assertThrows(HabilidadeInvalidaException.class,
            () -> new Lutador("Invalido", EstiloLuta.MMA, -10),
            "Deve lançar HabilidadeInvalidaException para habilidade negativa");
    }

    /**
     * Testa se uma exceção é lançada para habilidade acima de 100.
     */
    @Test
    @DisplayName("Deve lançar exceção para habilidade acima de 100")
    void testLutadorHabilidadeAcimaMaxima() {
        assertThrows(HabilidadeInvalidaException.class,
            () -> new Lutador("Invalido", EstiloLuta.MMA, 101),
            "Deve lançar HabilidadeInvalidaException para habilidade > 100");
    }

    /**
     * Testa a criação de um lutador com habilidade zero.
     */
    @Test
    @DisplayName("Deve criar lutador com habilidade zero")
    void testLutadorHabilidadeZero() {
        Lutador lutador = new Lutador("Zero", EstiloLuta.MMA, 0);
        assertEquals(0, lutador.getHabilidade(), "Habilidade deve ser 0");
    }

    /**
     * Testa se uma exceção é lançada para nome nulo ou vazio.
     */
    @Test
    @DisplayName("Deve lançar exceção para nome nulo ou vazio")
    void testLutadorNomeInvalido() {
        assertAll("Validações de nome",
            () -> assertThrows(IllegalArgumentException.class,
                () -> new Lutador(null, EstiloLuta.MMA, 50),
                "Deve lançar IllegalArgumentException para nome nulo"),
            () -> assertThrows(IllegalArgumentException.class,
                () -> new Lutador("", EstiloLuta.MMA, 50),
                "Deve lançar IllegalArgumentException para nome vazio")
        );
    }

    /**
     * Testa se uma exceção é lançada para estilo nulo.
     */
    @Test
    @DisplayName("Deve lançar exceção para estilo nulo")
    void testLutadorEstiloNulo() {
        assertThrows(IllegalArgumentException.class,
            () -> new Lutador("Valido", null, 50),
            "Deve lançar IllegalArgumentException para estilo nulo");
    }

    /**
     * Testa a adição de competidores ao torneio.
     */
    @Test
    @DisplayName("Deve adicionar competidores ao torneio")
    void testAdicionarCompetidor() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.BOXE, 50);
        Lutador l2 = new Lutador("Lutador2", EstiloLuta.MUAY_THAI, 60);
        torneio.adicionarCompetidor(l1);
        torneio.adicionarCompetidor(l2);
        assertAll("Verificação de adição",
            () -> assertEquals(2, torneio.getNumeroCompetidores(), "Deve ter dois competidores"),
            () -> assertTrue(torneio.getCompetidores().contains(l1), "Deve conter Lutador1"),
            () -> assertTrue(torneio.getCompetidores().contains(l2), "Deve conter Lutador2")
        );
    }

    /**
     * Testa se o logger registra a adição de competidores.
     */
    @Test
    @DisplayName("Deve registrar adição de competidor no logger")
    void testTorneioLoggerAdicionarCompetidor() {
        Lutador lutador = new Lutador("Lutador1", EstiloLuta.WRESTLING, 50);
        torneioLogger.adicionarCompetidor(lutador);
        String logText = logArea.getText();
        assertTrue(logText.contains("Competidor adicionado: Lutador1"),
            "Log deve conter mensagem de adição com nome do lutador");
    }

    /**
     * Testa se o torneio lança exceção com menos de dois competidores.
     */
    @Test
    @DisplayName("Deve lançar exceção ao iniciar torneio com menos de dois competidores")
    void testIniciarTorneioComPoucosCompetidores() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.MMA, 50);
        torneio.adicionarCompetidor(l1);
        assertThrows(IllegalStateException.class,
            () -> torneio.iniciarTorneio(),
            "Deve lançar IllegalStateException para torneio com menos de dois competidores");
    }

    /**
     * Testa a execução do torneio e a atribuição de pontos.
     */
    @Test
    @DisplayName("Deve executar torneio e atribuir pontos ao campeão")
    void testExecutarTorneioEPontos() {
        Lutador l1 = new Lutador("Lutador1", EstiloLuta.JIU_JITSU, 90);
        Lutador l2 = new Lutador("Lutador2", EstiloLuta.BOXE, 10);
        torneio.adicionarCompetidor(l1);
        torneio.adicionarCompetidor(l2);
        torneio.iniciarTorneio();
        assertEquals(1, torneio.getNumeroCompetidores(), "Deve restar apenas o campeão");
        Competidor campeao = torneio.getCompetidores().get(0);
        assertTrue(campeao == l1 || campeao == l2, "Campeão deve ser um dos competidores");
        assertEquals(1, ((Lutador) campeao).getPontos(), "Campeão deve ter 1 ponto");
    }
}