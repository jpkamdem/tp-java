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
    List<Integer> validValues = Arrays.asList(0, 1, 2, 3);
    Integer choice;

    do {
      System.out.println("=== ARENA LEGENDS ===");
      System.out.println("1. Lancer un dé");
      System.out.println("2. Calculer un rang");
      System.out.println("3. Test de coup critique");
      System.out.println("0. Quitter");
      System.out.println("Donne une valeur valide");

      choice = sc.nextInt();
    } while (!validValues.contains(choice));

    if (choice.equals(0)) {
      System.out.println("Fin du programme souhaitée.");
      return 0;
    }

    return choice;
  }

  // 2. Lancer un dé
  public static Integer roll() {
    Integer input = 0;
    boolean belongsToRange;
    do {
      System.out.println("Donne un nombre de face entre 4 et 20");
      input = sc.nextInt();
      belongsToRange = input >= 4 && input <= 20;
    } while (!belongsToRange);

    return random.nextInt(input) + 1;
  }

  // 3. Calculer un rang
  public static void rank(Integer position) {
    if (position.equals(0)) {
      System.out.println("Valeur invalide, fin de la partie.");
      return;
    }

    Integer bronzeRank = 100;
    Integer silverRank = 500;
    Integer goldRank = 1500;

    if (position < bronzeRank) {
      System.out.println("Rang du personnage : Bronze");
      return;
    }

    if (position < silverRank) {
      System.out.println("Rang du personnage : Silver");
      return;
    }

    if (position < goldRank) {
      System.out.println("Rang du personnage : Gold");
      return;
    }

    System.out.println("Rang du personnage : Legend");
    return;
  }

  // 4. Test de coup critique
  public static void criticalCounter() {
    Integer critRate = 15;
    Integer critCount = 0;
    Integer bound = 10000;
    Integer bestStreak = 0;
    Integer critStreak = 0;
    for (Integer i = 0; i < bound; i++) {
      Integer randomNumber = random.nextInt(100) + 1;
      if (randomNumber < critRate) {
        critCount++;
        critStreak++;

        if (critStreak > bestStreak) {
          bestStreak = critStreak;
        }
      } else {
        critStreak = 0;
      }
    }

    double actualCritRate = ((double) critCount / bound) * 100;
    System.out.println("Sur " + bound + " tirages, il y a eu " + critCount + ".");
    System.out.println("Meilleure série de coups critiques : " + bestStreak);
    System.out.println("Taux critique réel : " + actualCritRate);
  }

  public static void game() {
    Integer choice = menu();
    switch (choice) {
      case 1:
        Integer result = roll();
        System.out.println("Résultat du lancé de dé : " + result);
        break;

      case 2:
        System.out.println("Donne une position dans un classement, à partir de 1 : ");
        Integer input = sc.nextInt();
        rank(input);
        break;

      case 3:
        criticalCounter();
        break;
    }
  }
}