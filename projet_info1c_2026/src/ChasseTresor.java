import java.awt.*;
import java.util.Random;
import javax.swing.*;

// cspell:ignore Tresor
public class ChasseTresor {
    // Taille choisie dans le menu (8, 16 ou 32).
    private final int taille;
    // Position du tresor dans la grille.
    private final int xTresor;
    private final int yTresor;

    ChasseTresor(int taille) {
        // Sauvegarde la taille pour construire la carte.
        this.taille = taille;
        Random random = new Random();
        // Choisit une position aleatoire pour le tresor.
        this.xTresor = random.nextInt(taille);
        this.yTresor = random.nextInt(taille);
        afficherFenetre();
    }

    private void afficherFenetre() {
        // Fenetre du jeu.
        JFrame frame = new JFrame("Jeu - Chasse au Tresor");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Zone texte pour afficher la carte.
        JTextArea zone = new JTextArea();
        zone.setEditable(false);
        zone.setFont(new Font("Monospaced", Font.PLAIN, 20));
        zone.setText(construireCarteTexte());

        frame.add(new JScrollPane(zone), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private String construireCarteTexte() {
        StringBuilder sb = new StringBuilder();
        // X = position du tresor (visible pour version simple).
        sb.append("Carte ").append(taille).append("x").append(taille).append("\n\n");
        // Parcours de toute la grille ligne par ligne.
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (i == xTresor && j == yTresor) {
                    sb.append("X ");
                } else {
                    sb.append(". ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
