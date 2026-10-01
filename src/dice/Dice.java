package dice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dice {
  public static Scanner sc = new Scanner(System.in);
  public static Random random = new Random();

  // 1. Menu
  public static Integer menu() {
    List<Integer> valeursAcceptees = Arrays.asList(0, 1, 2, 3);
    Integer choix;

    do {
      System.out.println("=== ARENA LEGENDS ===");
      System.out.println("1. Lancer un dé");
      System.out.println("2. Calculer un rang");
      System.out.println("3. Test de coup critique");
      System.out.println("0. Quitter");
      System.out.println("Donne une valeur valide");

      choix = sc.nextInt();
    } while (!valeursAcceptees.contains(choix));

    if (choix.equals(0)) {
      System.out.println("Fin du programme souhaitée.");
      return 0;
    }

    return choix;
  }

  // 2. Lancer un dé
  public static Integer roll() {
    Integer input = 0;
    boolean respecteIntervalle;
    do {
      System.out.println("Donne un nombre de face entre 4 et 20");
      input = sc.nextInt();
      respecteIntervalle = input >= 4 && input <= 20;
    } while (!respecteIntervalle);

    return random.nextInt(input) + 1;
  }

  // 3. Calculer un rang
  public static void rang(Integer position) {
    if (position.equals(0)) {
      System.out.println("Valeur invalide, fin de la partie.");
      return;
    }

    Integer rangBronze = 100;
    Integer rangArgent = 500;
    Integer rangOr = 1500;

    if (position < rangBronze) {
      System.out.println("Rang du personnage : Bronze");
      return;
    }

    if (position < rangArgent) {
      System.out.println("Rang du personnage : Argent");
      return;
    }

    if (position < rangOr) {
      System.out.println("Rang du personnage : Or");
      return;
    }

    System.out.println("Rang du personnage : Légende");
    return;
  }

  // 4. Test de coup critique
  public static void compteurCritique() {
    Integer tauxCritique = 15;
    Integer nbCoupsCritiques = 0;
    Integer bound = 10000;
    Integer meilleureSerieCritique = 0;
    Integer serieCritiqueActuelle = 0;
    for (Integer i = 0; i < bound; i++) {
      Integer nombreAuHasard = random.nextInt(100) + 1;
      if (nombreAuHasard < tauxCritique) {
        nbCoupsCritiques++;
        serieCritiqueActuelle++;

        if (serieCritiqueActuelle > meilleureSerieCritique) {
          meilleureSerieCritique = serieCritiqueActuelle;
        }
      } else {
        serieCritiqueActuelle = 0;
      }
    }

    double tauxCritiqueReel = ((double) nbCoupsCritiques / bound) * 100;
    System.out.println("Sur " + bound + " tirages, il y a eu " + nbCoupsCritiques + ".");
    System.out.println("Meilleure série de coups critiques : " + meilleureSerieCritique);
    System.out.println("Taux critique réel : " + tauxCritiqueReel);
  }

  public static void game() {
    Integer choix = menu();
    switch (choix) {
      case 1:
        Integer resultat = roll();
        System.out.println("Résultat du lancé de dé : " + resultat);
        break;

      case 2:
        System.out.println("Donne une position dans un classement, à partir de 1 : ");
        Integer input = sc.nextInt();
        rang(input);
        break;

      case 3:
        compteurCritique();
        break;
    }
  }
}