import java.util.Scanner;

public class Calculator {
  static Scanner sc = new Scanner(System.in);

  public static Integer sum(Integer foo, Integer bar) {
    return foo + bar;
  }

  public static Integer substraction(Integer foo, Integer bar) {
    return foo - bar;
  }

  public static Integer time(Integer foo, Integer bar) {
    return foo * bar;
  }

  public static Boolean zeroChecker(Integer foo, Integer bar) {
    return foo != 0 && bar != 0;
  }

  public static Integer division(Integer foo, Integer bar) {
    if (!zeroChecker(foo, bar)) {
      System.err.println("Pas de 0");
      return 0;
    }

    return foo % bar;
  }

  public static void calc() {
    System.out.println("Addition (1), soustraction (2), multiplication (3) ou division (4) ? :");
    System.out.println("Pour quitter, taper 'exit'");
    String choice = sc.next();
    Integer result;
    Integer first;
    Integer second;

    while (choice != "exit") {
      switch (choice) {
        case "1":
          System.out.println("Première valeur : ");
          first = sc.nextInt();
          System.out.println("Seconde valeur : ");
          second = sc.nextInt();
          result = sum(first, second);
          System.err.println(first + " * " + second + " = " + result);
          break;

        case "2":
          System.out.println("Première valeur : ");
          first = sc.nextInt();
          System.out.println("Seconde valeur : ");
          second = sc.nextInt();
          result = substraction(first, second);
          System.err.println(first + " * " + second + " = " + result);
          break;

        case "3":
          System.out.println("Première valeur : ");
          first = sc.nextInt();
          System.out.println("Seconde valeur : ");
          second = sc.nextInt();
          result = time(first, second);
          System.err.println(first + " * " + second + " = " + result);
          break;

        case "4":
          System.out.println("Première valeur : ");
          first = sc.nextInt();
          System.out.println("Seconde valeur : ");
          second = sc.nextInt();
          result = division(first, second);
          System.err.println(first + " * " + second + " = " + result);
          break;

        default:
          break;
      }
    }
    return;
  }

  public static void main(String[] args) throws Exception {
    calc();
  }
}