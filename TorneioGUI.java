import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface gráfica simples para gerir um torneio de MMA.
 */
public class TorneioGUI extends JFrame {

    private Torneio torneio;
    private JTextArea logTextArea;

    public TorneioGUI() {
        super("Torneio de MMA");

        torneio = new Torneio();
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JTextField nomeField = new JTextField();
        JTextField estiloField = new JTextField();
        JTextField habilidadeField = new JTextField();

        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Estilo:"));
        inputPanel.add(estiloField);
        inputPanel.add(new JLabel("Habilidade (0-100):"));
        inputPanel.add(habilidadeField);

        JButton addButton = new JButton("Adicionar Lutador");
        JButton startButton = new JButton("Iniciar Torneio");

        inputPanel.add(addButton);
        inputPanel.add(startButton);

        add(inputPanel, BorderLayout.NORTH);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Adiciona ação ao botão de adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText().trim();
                    String estilo = estiloField.getText().trim();
                    int habilidade = Integer.parseInt(habilidadeField.getText().trim());

                    if (nome.isEmpty() || estilo.isEmpty() || habilidade < 0 || habilidade > 100) {
                        JOptionPane.showMessageDialog(TorneioGUI.this, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    torneio.adicionarCompetidor(new Lutador(nome, estilo, habilidade));
                    logTextArea.append("Lutador adicionado: " + nome + "\n");

                    nomeField.setText("");
                    estiloField.setText("");
                    habilidadeField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TorneioGUI.this, "Habilidade deve ser um número!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona ação ao botão de iniciar
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logTextArea.append("\n--- TORNEIO ---\n");
                torneio = new TorneioLogger(logTextArea); // usa versão com log
                iniciarTorneio();
            }
        });

        setVisible(true);
    }

    private void iniciarTorneio() {
        // Simula um torneio com 4 lutadores fixos (ou vindos da interface)
        Competidor l1 = new Lutador("Anderson Silva", "Muay Thai", 85);
        Competidor l2 = new Lutador("Tomás Adão", "Kickboxing", 75);
        Competidor l3 = new Lutador("Khabib Nurmagomedov", "Jiu-Jitsu", 88);
        Competidor l4 = new Lutador("Adalgisa Pedro", "Boxe", 54);

        torneio.adicionarCompetidor(l1);
        torneio.adicionarCompetidor(l2);
        torneio.adicionarCompetidor(l3);
        torneio.adicionarCompetidor(l4);

        torneio.iniciarTorneio();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TorneioGUI());
    }
}