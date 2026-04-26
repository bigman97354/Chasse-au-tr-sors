import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Lance l'interface graphique dans le thread Swing.
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu - Chasse au Tresor");
            frame.setSize(700, 360);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            Color couleurMenu = new Color(218, 165, 32);
            frame.getContentPane().setBackground(couleurMenu);

            // Titre du menu principal.
            JLabel titre = new JLabel("Choisis la taille du terrain", SwingConstants.CENTER);
            titre.setFont(new Font("Arial", Font.BOLD, 24));
            titre.setForeground(Color.WHITE);
            titre.setOpaque(true);
            titre.setBackground(couleurMenu);

            // 3 tailles possibles pour la carte.
            JButton bouton8 = new JButton("8 x 8");
            JButton bouton16 = new JButton("16 x 16");
            JButton bouton32 = new JButton("32 x 32");
            bouton8.setFont(new Font("Arial", Font.BOLD, 20));
            bouton16.setFont(new Font("Arial", Font.BOLD, 20));
            bouton32.setFont(new Font("Arial", Font.BOLD, 20));
            bouton8.setPreferredSize(new Dimension(120, 70));
            bouton16.setPreferredSize(new Dimension(120, 70));
            bouton32.setPreferredSize(new Dimension(120, 70));

            // Chaque bouton demarre une partie avec une taille differente.
            bouton8.addActionListener(e -> {
                new ChasseTresor(8);
                frame.dispose();
            });
            bouton16.addActionListener(e -> {
                new ChasseTresor(16);
                frame.dispose();
            });
            bouton32.addActionListener(e -> {
                new ChasseTresor(32);
                frame.dispose();
            });

            // Zone centrale qui contient les boutons.
            JPanel centre = new JPanel(new GridLayout(1, 3, 12, 12));
            centre.setBackground(couleurMenu);
            centre.add(bouton8);
            centre.add(bouton16);
            centre.add(bouton32);

            frame.add(titre, BorderLayout.NORTH);
            frame.add(centre, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}