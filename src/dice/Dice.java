package dice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dice {
  public static Scanner sc = new Scanner(System.in);
  public static Random random = new Random();

  // 1. Menu
  public static Integer menu(Integer choice) {
    System.out.println("=== ARENA LEGENDS ===");
    System.out.println("2. Calculer un rang");
    System.out.println("3. Test de coup critique");
    System.out.println("0. Quitter");

    List<Integer> validValues = Arrays.asList(0, 1, 2, 3);

    do {
      System.out.println("=== ARENA LEGENDS ===");
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
  public static Integer roll(Integer input) {
    boolean belongsToRange = input >= 4 && input <= 20;
    while (!belongsToRange) {
      System.out.println("Donne un nombre de face entre 4 et 20");
      input = sc.nextInt();
    }

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
      Integer randomNumber = random.nextInt(100);
      if (randomNumber < critRate) {
        critCount++;
        critStreak++;

        if (critStreak > bestStreak) {
          bestStreak = critStreak;
        }
      }
    }

    Integer actualCritRate = (critCount / bound) * 100;
  }
}