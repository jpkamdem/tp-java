import combattant.Combattant;
import tournoi.Tournoi;

public class Main {
  public static void main(String[] args) {
    Tournoi tournoi = new Tournoi().creerTournoi();
    Combattant champion = tournoi.lancer();
    System.out.println("CHAMPION : " + champion);
    System.out.println("--- Classsement ---");
    tournoi.classement().forEach(System.out::println);
    tournoi.statsParClasse();
  }
}