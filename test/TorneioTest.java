import src.HabilidadeInvalidaException;
import src.Lutador;

public class TorneioTest {
    /**Suite de Testes**: `TorneioTest.java` verifica:
     * Criação válida de lutadores
     * Rejeição de habilidades inválidas
     */
    @Test
    public void testLutadorValido() {
        Lutador l = new Lutador("Valido", 50);
        assertEquals(50, l.getHabilidade());
    }

    @Test(expected = HabilidadeInvalidaException.class)
    public void testLutadorInvalido() {
        new Lutador("Invalido", -10);
    }
}