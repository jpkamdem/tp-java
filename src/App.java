import comptebancaire.CompteBancaire;

public class App {

  public static void main(String[] args) {
    CompteBancaire compte = new CompteBancaire();

    compte.deposer(2000);
    System.out.println("Solde : " + compte.getSolde());
  }
}