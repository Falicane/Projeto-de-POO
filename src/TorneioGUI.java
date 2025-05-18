package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interface gráfica para o torneio de MMA, usando Swing.
 * Exibe logs e uma lista visual de competidores adicionados.
 */
public class TorneioGUI extends JFrame {
    private TorneioLogger torneio;
    private JTextArea logArea;
    private DefaultListModel<String> competidoresModel;
    private JList<String> competidoresList;

    /**
     * Construtor que inicializa a interface gráfica.
     */
    public TorneioGUI() {
        super("Torneio de MMA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Área de log
        logArea = new JTextArea();
        logArea.setEditable(false);
        torneio = new TorneioLogger(logArea);

        // Lista de competidores
        competidoresModel = new DefaultListModel<>();
        competidoresList = new JList<>(competidoresModel);
        competidoresList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Layout principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de log
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.setBorder(BorderFactory.createTitledBorder("Log do Torneio"));
        logPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

        // Painel de competidores
        JPanel competidoresPanel = new JPanel(new BorderLayout());
        competidoresPanel.setBorder(BorderFactory.createTitledBorder("Competidores"));
        competidoresPanel.add(new JScrollPane(competidoresList), BorderLayout.CENTER);

        // Divide a área central entre log e competidores
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, competidoresPanel, logPanel);
        splitPane.setDividerLocation(200);
        panel.add(splitPane, BorderLayout.CENTER);

        // Botões
        JButton btnAdd = new JButton("Adicionar Lutador");
        btnAdd.addActionListener(this::adicionarLutador);

        JButton btnStart = new JButton("Iniciar Torneio");
        btnStart.addActionListener(e -> torneio.iniciarTorneio());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnStart);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    /**
     * Adiciona um lutador com base em entrada do usuário.
     * @param e Evento do botão.
     */
    private void adicionarLutador(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog(this, "Nome do Lutador:");
            String habilidadeStr = JOptionPane.showInputDialog(this, "Habilidade (0-100):");
            int habilidade = Integer.parseInt(habilidadeStr);

            // Diálogo para selecionar estilo de luta
            EstiloLuta[] estilos = EstiloLuta.values();
            EstiloLuta estilo = (EstiloLuta) JOptionPane.showInputDialog(
                this,
                "Selecione o estilo de luta:",
                "Estilo de Luta",
                JOptionPane.PLAIN_MESSAGE,
                null,
                estilos,
                EstiloLuta.MMA
            );

            Lutador lutador = new Lutador(nome, estilo, habilidade);
            torneio.adicionarCompetidor(lutador);
            // Atualiza a lista visual
            competidoresModel.addElement(lutador.getDescricao());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Habilidade deve ser um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (HabilidadeInvalidaException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ponto de entrada da aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TorneioGUI::new);
    }
}