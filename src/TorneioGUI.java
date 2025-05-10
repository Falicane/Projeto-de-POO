package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TorneioGUI extends JFrame {
    private TorneioLogger torneio;
    private JTextArea logArea;

    public TorneioGUI() {
        super("Torneio de MMA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        logArea = new JTextArea();
        logArea.setEditable(false);
        torneio = new TorneioLogger(logArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(logArea), BorderLayout.CENTER);

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

    private void adicionarLutador(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Lutador:");
            int habilidade = Integer.parseInt(JOptionPane.showInputDialog("Habilidade (0-100):"));
            torneio.adicionarCompetidor(new Lutador(nome, habilidade));
        } catch (HabilidadeInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TorneioGUI::new);
    }
}