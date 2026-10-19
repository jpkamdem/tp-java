import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

public class Calculatrice {

    private JFrame frame;
    private JTextField affichage;

    private double premierNombre;
    private String operateur = "";
    private boolean nouvelleSaisie = true;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                Calculatrice window = new Calculatrice();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculatrice() {
        initialize();
    }

    private void initialize() {

        // Fenêtre principale
        frame = new JFrame();
        frame.setTitle("Ma calculatrice");
        frame.setBounds(100, 100, 350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);

        frame.getContentPane().setLayout(
            new BorderLayout(8, 8)
        );

        // Écran d'affichage
        affichage = new JTextField("0");
        affichage.setEditable(false);

        affichage.setHorizontalAlignment(
            SwingConstants.RIGHT
        );

        affichage.setFont(
            new Font("Arial", Font.BOLD, 28)
        );

        affichage.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        frame.getContentPane().add(
            affichage, BorderLayout.NORTH
        );

        // Panneau des boutons
        JPanel panel = new JPanel();

        panel.setLayout(
            new GridLayout(4, 4, 5, 5)
        );

        String[] touches = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        // Création des boutons
        for (String touche : touches) {

            JButton bouton = new JButton(touche);

            bouton.setFont(
                new Font("Arial", Font.BOLD, 20)
            );

            bouton.setFocusPainted(false);

            // Couleur des opérateurs
            if ("/*-+=".contains(touche)
                    && touche.length() == 1) {

                bouton.setBackground(
                    new Color(255, 149, 0)
                );

                bouton.setForeground(Color.WHITE);

            } else if (touche.equals("C")) {

                bouton.setBackground(
                    new Color(210, 210, 210)
                );

            } else {

                bouton.setBackground(Color.WHITE);
            }

            // Action du bouton
            bouton.addActionListener(e -> {
                traiterTouche(touche);
            });

            panel.add(bouton);
        }

        frame.getContentPane().add(
            panel, BorderLayout.CENTER
        );

        // Marges de la fenêtre
        ((JPanel) frame.getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
    }

    private void traiterTouche(String touche) {

        // Effacer l'écran
        if (touche.equals("C")) {

            affichage.setText("0");
            premierNombre = 0;
            operateur = "";
            nouvelleSaisie = true;

            return;
        }

        // Saisir un chiffre
        if (touche.matches("[0-9]")) {

            if (nouvelleSaisie) {

                affichage.setText(touche);
                nouvelleSaisie = false;

            } else if (affichage.getText().equals("0")) {

                affichage.setText(touche);

            } else {

                affichage.setText(
                    affichage.getText() + touche
                );
            }

            return;
        }

        // Choisir une opération
        if (touche.matches("[+*/-]")) {

            premierNombre = Double.parseDouble(
                affichage.getText()
            );

            operateur = touche;
            nouvelleSaisie = true;

            return;
        }

        // Effectuer le calcul
        if (touche.equals("=")) {

            if (operateur.isEmpty()) {
                return;
            }

            double deuxiemeNombre = Double.parseDouble(
                affichage.getText()
            );

            double resultat;

            switch (operateur) {

                case "+":
                    resultat = premierNombre + deuxiemeNombre;
                    break;

                case "-":
                    resultat = premierNombre - deuxiemeNombre;
                    break;

                case "*":
                    resultat = premierNombre * deuxiemeNombre;
                    break;

                case "/":

                    if (deuxiemeNombre == 0) {

                        affichage.setText("Erreur");
                        operateur = "";
                        nouvelleSaisie = true;

                        return;
                    }

                    resultat = premierNombre / deuxiemeNombre;
                    break;

                default:
                    return;
            }

            // Afficher le résultat
            affichage.setText(
                formatNombre(resultat)
            );

            operateur = "";
            nouvelleSaisie = true;
        }
    }

    // Éviter les résultats du type 10.0
    private String formatNombre(double nombre) {

        if (Double.isFinite(nombre)
                && nombre == Math.rint(nombre)
                && Math.abs(nombre) < 1e15) {

            return String.valueOf((long) nombre);
        }

        return String.valueOf(nombre);
    }
}